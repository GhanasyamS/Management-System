package com.project.timesheetservicemodule.Service;



import com.project.timesheetservicemodule.Domain.TimeSheet;
import com.project.timesheetservicemodule.Exception.TimeSheetAlreadyExistsException;
import com.project.timesheetservicemodule.Exception.TimeSheetNotFoundException;
import com.project.timesheetservicemodule.Repository.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TimeSheetService implements ITimeSheetService
{
    TimeSheetRepository timeSheetRepository;

    @Autowired
    public TimeSheetService(TimeSheetRepository timeSheetRepository)
    {
        this.timeSheetRepository = timeSheetRepository;
    }

    @Override
    public TimeSheet createTimeSheet(TimeSheet timeSheet) throws TimeSheetAlreadyExistsException
    {
        if(timeSheetRepository.findByProjectIdAndEmployeeIdAndDate(timeSheet.getProjectId(),timeSheet.getEmployeeId(),timeSheet.getDate())!=null)
            throw new TimeSheetAlreadyExistsException("Timesheet already exists");
        timeSheet.setCreatedAt(LocalDateTime.now());
        timeSheet.setUpdatedAt(LocalDateTime.now());
        timeSheet.setUpdatedBy(timeSheet.getCreatedBy());
        timeSheet.setTotalWeekHours(
                calculateWeeklyTotal(
                        timeSheet.getEmployeeId(),
                        timeSheet.getProjectId(),
                        timeSheet.getWeekStart(),
                        0.0,
                        timeSheet.getHours()
                )
        );

        return timeSheetRepository.save(timeSheet);
    }

    @Override
    public TimeSheet findTimeSheetById(UUID timeSheetID) throws TimeSheetNotFoundException
    {
        return timeSheetRepository.findById(timeSheetID).orElseThrow(()->new TimeSheetNotFoundException("Timesheet not found"));
    }
    @Override
    public List<TimeSheet> getAllTimeSheets()
    {
        return timeSheetRepository.findAll();
    }

    @Override
    public TimeSheet updateTimeSheet(UUID timeSheetID, TimeSheet timeSheet) throws TimeSheetNotFoundException, TimeSheetAlreadyExistsException
    {

        return timeSheetRepository.findById(timeSheetID)
                .map(existingTimeSheet->{

                    TimeSheet duplicate = timeSheetRepository.findDuplicateOnUpdate(
                            timeSheet.getEmployeeId(),
                            timeSheet.getProjectId(),
                            timeSheet.getDate(),
                            timeSheetID
                    );
                    if (duplicate != null) {
                        throw new TimeSheetAlreadyExistsException("A timesheet for this date, employee, and project already exists.");
                    }

                    existingTimeSheet.setProjectName(timeSheet.getProjectName());
                    existingTimeSheet.setProjectId(timeSheet.getProjectId());
                    existingTimeSheet.setDate(timeSheet.getDate());
                    existingTimeSheet.setStatus(timeSheet.getStatus());
                    existingTimeSheet.setTotalWeekHours(calculateWeeklyTotal(timeSheet.getEmployeeId(),timeSheet.getProjectId(),timeSheet.getWeekStart(), existingTimeSheet.getHours(), timeSheet.getHours()));
                    existingTimeSheet.setUpdatedAt(LocalDateTime.now());
                    existingTimeSheet.setHours((timeSheet.getHours()));
                    existingTimeSheet.setUpdatedBy(timeSheet.getUpdatedBy());

                   return timeSheetRepository.save(existingTimeSheet);
                })
                .orElseThrow(()->new TimeSheetNotFoundException("Timesheet not found"));
    }

    @Override
    public void deleteTimeSheet(UUID timeSheetID) throws TimeSheetNotFoundException
    {
        TimeSheet ts = timeSheetRepository.findById(timeSheetID)
                .orElseThrow(()->new TimeSheetNotFoundException("Timesheet not found"));

        timeSheetRepository.delete(ts);
    }

    private Double calculateWeeklyTotal(UUID employeeId, UUID projectId, LocalDate weekStart,
                                        Double previousHours, Double newHours)
    {
        // Fetch total hours from DB for the given employee/project/week
        Double totalHours = timeSheetRepository.findTotalHoursByEmployeeAndWeek(employeeId, projectId, weekStart);
        System.out.println("Total hours : "+totalHours);
        // Adjust the total to account for the update (remove old value, add new value)
        double adjustedTotal = (totalHours != null ? totalHours : 0.0)
                - (previousHours != null ? previousHours : 0.0)
                + (newHours != null ? newHours : 0.0);
        System.out.println("Adjusted hours : "+adjustedTotal);
        return adjustedTotal;
    }


}

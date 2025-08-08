package com.project.timesheetservicemodule.Controller;

import com.project.timesheetservicemodule.Domain.TimeSheet;
import com.project.timesheetservicemodule.Exception.TimeSheetAlreadyExistsException;
import com.project.timesheetservicemodule.Exception.TimeSheetNotFoundException;
import com.project.timesheetservicemodule.Service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController
{

    private final TimeSheetService timeSheetService;

    @Autowired
    public TimeSheetController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }


    @PostMapping("/create")
    public ResponseEntity<TimeSheet> createTimeSheet(@RequestBody TimeSheet timeSheet)
            throws TimeSheetAlreadyExistsException {
        TimeSheet created = timeSheetService.createTimeSheet(timeSheet);
        return ResponseEntity.ok(created);
    }


    @GetMapping("findbyid/{id}")
    public ResponseEntity<TimeSheet> getTimeSheetById(@PathVariable("id") UUID id)
            throws TimeSheetNotFoundException {
        TimeSheet timeSheet = timeSheetService.findTimeSheetById(id);
        return ResponseEntity.ok(timeSheet);
    }

    @GetMapping("/findall")
    public  ResponseEntity<List<TimeSheet>> getAllTimeSheets()
    {
        List<TimeSheet> timeSheets = timeSheetService.getAllTimeSheets();
        return ResponseEntity.ok(timeSheets);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TimeSheet> updateTimeSheet(@PathVariable("id") UUID id,
                                                     @RequestBody TimeSheet updatedTimeSheet)
            throws TimeSheetNotFoundException {
        TimeSheet updated = timeSheetService.updateTimeSheet(id, updatedTimeSheet);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTimeSheet(@PathVariable("id") UUID id)
            throws TimeSheetNotFoundException {
        timeSheetService.deleteTimeSheet(id);
        return ResponseEntity.ok("Timesheet deleted successfully.");
    }
}

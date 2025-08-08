package com.project.timesheetservicemodule.Repository;


import com.project.timesheetservicemodule.Domain.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, UUID>
{
    TimeSheet findByProjectIdAndEmployeeIdAndDate(UUID projectId, UUID employeeId, LocalDate date);


    @Query(
            value = """
        SELECT COALESCE(SUM(hours), 0)
        FROM time_sheet
        WHERE employee_id = :employeeId
          AND project_id = :projectId
          AND week_start = :weekStart
    """,
            nativeQuery = true
    )
    Double findTotalHoursByEmployeeAndWeek(
            @Param("employeeId") UUID employeeId,
            @Param("projectId") UUID projectId,
            @Param("weekStart") LocalDate weekStart
    );


    @Query("SELECT t FROM TimeSheet t WHERE t.employeeId = :employeeId AND t.projectId = :projectId AND t.date = :date AND t.id <> :excludeId")
    TimeSheet findDuplicateOnUpdate(
            @Param("employeeId") UUID employeeId,
            @Param("projectId") UUID projectId,
            @Param("date") LocalDate date,
            @Param("excludeId") UUID excludeId
    );


}

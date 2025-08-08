package com.project.timesheetservicemodule.Service;



import com.project.timesheetservicemodule.Domain.TimeSheet;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

public interface ITimeSheetService
{
    TimeSheet createTimeSheet(TimeSheet timeSheet);
    TimeSheet findTimeSheetById(UUID timeSheetID);
    TimeSheet updateTimeSheet(UUID timeSheetID, TimeSheet timeSheet);
    void deleteTimeSheet(UUID timeSheetID);
    List<TimeSheet> getAllTimeSheets();
}

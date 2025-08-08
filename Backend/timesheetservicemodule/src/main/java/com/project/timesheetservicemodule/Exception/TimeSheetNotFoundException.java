package com.project.timesheetservicemodule.Exception;

public class TimeSheetNotFoundException extends RuntimeException {
    public TimeSheetNotFoundException(String message) {
        super(message);
    }
}

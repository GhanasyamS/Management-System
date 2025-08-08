package com.project.timesheetservicemodule.Exception;

public class TimeSheetAlreadyExistsException extends RuntimeException {
    public TimeSheetAlreadyExistsException(String message) {
        super(message);
    }
}

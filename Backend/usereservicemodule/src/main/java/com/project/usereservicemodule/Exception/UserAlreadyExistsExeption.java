package com.project.usereservicemodule.Exception;

public class UserAlreadyExistsExeption extends RuntimeException {
    public UserAlreadyExistsExeption(String message) {
        super(message);
    }
}

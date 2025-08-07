package com.project.usereservicemodule.Service;

import com.project.usereservicemodule.Domain.User;
import com.project.usereservicemodule.Exception.UserAlreadyExistsExeption;
import com.project.usereservicemodule.Exception.UserNotFoundException;

import java.util.UUID;

public interface IUserService
{
    User createUser(User user) throws UserAlreadyExistsExeption;
    User findUserByUserName(String userName) throws UserNotFoundException;
    User updateUserDataByID(User user, UUID userID) throws UserNotFoundException;
    void deleteUserDataByID(UUID UserID)throws UserNotFoundException;
}

package com.project.usereservicemodule.Service;

import com.project.usereservicemodule.Domain.User;
import com.project.usereservicemodule.Exception.UserAlreadyExistsExeption;
import com.project.usereservicemodule.Exception.UserNotFoundException;
import com.project.usereservicemodule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistsExeption
    {
         return userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) throws UserNotFoundException
    {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User updateUserDataByID(User user, UUID userID) throws UserNotFoundException
    {
       return  userRepository.findById(userID)
                 .map(existingUser -> {
                     existingUser.setUserName(user.getUserName());
                     existingUser.setUpdatedBy(user.getUpdatedBy());
                     existingUser.setEmployeeId(user.getEmployeeId());
                     existingUser.setRole(user.getRole());
                     existingUser.setLastLogin(user.getLastLogin());
                     return userRepository.save(existingUser);

                 })
                .orElseThrow(()->new UserNotFoundException("User not found"));


    }

    @Override
    public void deleteUserDataByID(UUID userID) throws UserNotFoundException
    {
        userRepository.findById(userID)
                .orElseThrow(()->new UserNotFoundException("User not found"));

        userRepository.deleteById(userID);

    }
}

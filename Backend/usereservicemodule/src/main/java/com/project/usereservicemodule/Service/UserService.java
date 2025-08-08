package com.project.usereservicemodule.Service;

import com.project.usereservicemodule.DTO.UserAuthDTO;
import com.project.usereservicemodule.DTO.UserDTO;
import com.project.usereservicemodule.Domain.User;
import com.project.usereservicemodule.Exception.UserAlreadyExistsExeption;
import com.project.usereservicemodule.Exception.UserNotFoundException;
import com.project.usereservicemodule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService implements IUserService
{
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createUser(User user) throws UserAlreadyExistsExeption
    {
        user.setCreatedAt(LocalDateTime.now());
        user.setLastLogin(null);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
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

    @Override
    public UserDTO authenticateUser(UserAuthDTO userAuthDTO) throws UserNotFoundException
    {
        User userObj = null;


        if(userAuthDTO.getUserName() != null && !userAuthDTO.getUserName().isEmpty())
        {
            userObj = userRepository.findByUserName(userAuthDTO.getUserName());
        }

        if (userObj == null) {
            throw new UserNotFoundException("User not found!");
        }

        if (userObj.getUserPassword() != null && !userObj.getUserPassword().isEmpty()
                && passwordEncoder.matches(userAuthDTO.getUserPassword(), userObj.getUserPassword()))
        {

            return UserMapper.toDTO(userObj);


        } else {
            throw new UserNotFoundException("Invalid Credentials!!!");
        }

    }


}

package com.project.usereservicemodule.Controller;

import com.project.usereservicemodule.DTO.UserAuthDTO;
import com.project.usereservicemodule.DTO.UserDTO;
import com.project.usereservicemodule.Domain.User;
import com.project.usereservicemodule.Exception.UserAlreadyExistsExeption;
import com.project.usereservicemodule.Exception.UserNotFoundException;
import com.project.usereservicemodule.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/user")
public class UserController
{

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) throws UserAlreadyExistsExeption {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/finduserbyusername/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("userName") String userName) throws UserNotFoundException {
        User user = userService.findUserByUserName(userName);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") UUID userId) throws UserNotFoundException {
        User updatedUser = userService.updateUserDataByID(user, userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") UUID userId) throws UserNotFoundException {
        userService.deleteUserDataByID(userId);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> UserLogin(@RequestBody UserAuthDTO userAuthDTO) throws UserNotFoundException
    {

            UserDTO userObj = userService.authenticateUser(userAuthDTO);
            return new ResponseEntity<>(userObj, HttpStatus.OK);

    }
}

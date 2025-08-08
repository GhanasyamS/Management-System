package com.example.kanbanboard.authenticationService.DTO;

import com.example.kanbanboard.authenticationService.Model.Role;

import java.util.UUID;

public class UserDTO
{
    private UUID userId;

    private String userName;

    private UUID employeeId;

    private Role role;


    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package com.project.usereservicemodule.Service;


import com.project.usereservicemodule.DTO.UserDTO;
import com.project.usereservicemodule.Domain.User;

public class UserMapper
{


    // Convert domain User -> UserDTO (for response)
    public static UserDTO toDTO(User user)
    {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setRole(user.getRole());
        dto.setEmployeeId((user.getEmployeeId()));


        return dto;
    }

}

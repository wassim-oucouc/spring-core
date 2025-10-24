package com.example.mapper;

import com.example.dto.request.UserDTO;
import com.example.dto.response.UserDTOResponse;
import com.example.entity.Users;

import java.time.LocalDateTime;

public class UserMapper {

    public static UserDTOResponse toUserDTOResponse(Users users) {
        if (users == null) {
            return null;
        }

        UserDTOResponse dto = new UserDTOResponse();
        dto.setId(users.getId());
        dto.setName(users.getName());
        dto.setEmail(users.getEmail());
        dto.setActive(users.getActive());
        dto.setCreatedAt(users.getCreatedAt());
        dto.setRole(users.getRole());
        return dto;
    }

    public static Users toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        Users users = new Users();
        users.setName(dto.getName());
        users.setEmail(dto.getEmail());
        users.setPassword(dto.getPassword());
        users.setActive(dto.getActive());
        users.setRole(dto.getRole());
        users.setCreatedAt(LocalDateTime.now());
        return users;
    }
}

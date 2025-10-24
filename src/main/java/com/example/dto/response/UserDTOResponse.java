package com.example.dto.response;


import com.example.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTOResponse{

    private Long id;
    private String name;
    private String email;
    private Boolean active;
    private LocalDateTime createdAt;
    private Role role;
}

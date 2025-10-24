package com.example.dto.request;

import com.example.enumeration.Role;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserDTO {

    private Long id;

    private String name;
    private String email;
    private String password;
    private Boolean active;
    private Role role;
}

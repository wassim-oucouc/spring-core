package com.example.entity;

import com.example.enumeration.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Boolean active;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private com.example.enumeration.Role role;

    public Users() {} // constructeur par défaut requis

    public Users(String name, String email, String password, com.example.enumeration.Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

}

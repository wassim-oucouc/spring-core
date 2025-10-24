package com.example.controller;


import com.example.dto.request.UserDTO;
import com.example.dto.response.UserDTOResponse;
import com.example.entity.Users;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@Slf4j
public class UserController {



    public UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/add/user")

    public UserDTOResponse addUser(@RequestBody UserDTO userDTO)
    {
        Users users = UserMapper.toEntity(userDTO);
        Users usersCreated =  this.userService.createUser(users);

        return UserMapper.toUserDTOResponse(usersCreated);
    }

    @GetMapping("/user/{id}")
    public UserDTOResponse getUserById(@PathVariable("id") long id) {
        Optional<Users> userOptional = this.userService.findUserById(id);

        Users users = null;
        if (userOptional.isPresent()) {
            users = userOptional.get();
        }


        return UserMapper.toUserDTOResponse(users);
    }

    @GetMapping("/user/update/{id}")
    public UserDTOResponse updateUserById(@PathVariable("id") long id,@RequestBody UserDTO userDTO)
    {
        Users users = UserMapper.toEntity(userDTO);
        Optional<Users> usersOptional = this.userService.updateUserById(id,users);
        Users users1 = usersOptional.get();
        return UserMapper.toUserDTOResponse(users1);
    }

    @GetMapping("/user/list")
    public List<UserDTOResponse> getListUserPageable(@RequestParam("page") int page, @RequestParam("size") int size)
    {
        Page<Users> users = this.userService.getUsersPageable(page,size,"name",true);
        return users.getContent().stream().map(UserMapper::toUserDTOResponse).toList();


    }


}

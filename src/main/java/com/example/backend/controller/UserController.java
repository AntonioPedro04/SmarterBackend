package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/login")
    public User validateLogin(@RequestBody User user){
        return userService.validateLogin(user);
    }


}

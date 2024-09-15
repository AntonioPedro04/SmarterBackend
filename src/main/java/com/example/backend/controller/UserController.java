package com.example.backend.controller;

import com.example.backend.model.entity.User;
import com.example.backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/logged")
    public User getLoggedUser(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        User user = findUserByUsername(username);
        return user;
    }

    @GetMapping("/{username}")
    public User findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

}

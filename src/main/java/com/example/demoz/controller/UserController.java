package com.example.demoz.controller;

import com.example.demoz.model.User;
import com.example.demoz.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
            public  User add(@RequestParam String name,
                                @RequestParam int age){
                return userService.add(name,age);
            }
            @GetMapping("find")
            public User find(@RequestParam String name,
                             @RequestParam int age){
                return userService.find(name,age);
    }

             @GetMapping("/remove")
             public User remove(@RequestParam String name,
                                @RequestParam int age){
                 return userService.remove(name,age);
    }
    @GetMapping
        public List<User> findAll() {
            return  userService.findAll();
    }
}

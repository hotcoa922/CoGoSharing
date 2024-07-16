package com.example.cogosharing.controller;


import com.example.cogosharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //의존성 주입 -> 생성자 주입 방식
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    public void registerUser(){
//        userService.
//    }
}



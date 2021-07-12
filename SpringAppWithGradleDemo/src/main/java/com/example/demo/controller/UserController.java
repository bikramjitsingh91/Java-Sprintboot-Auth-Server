package com.example.demo.controller;

import com.example.demo.controller.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public UserInfo getUserInfo(){
        UserInfo user = new UserInfo("Bikram","Eng","12345");

        return  user;
    }
}

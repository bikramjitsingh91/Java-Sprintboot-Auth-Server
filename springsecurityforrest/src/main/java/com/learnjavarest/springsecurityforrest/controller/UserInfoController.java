package com.learnjavarest.springsecurityforrest.controller;

import com.learnjavarest.springsecurityforrest.model.UserReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserInfoController {

    @GetMapping("/userData")
    public ResponseEntity<UserReq> getUserData(){
        UserReq userReq = new UserReq("vicky","12345");
        return new ResponseEntity<UserReq>(userReq, HttpStatus.OK);
    }


}

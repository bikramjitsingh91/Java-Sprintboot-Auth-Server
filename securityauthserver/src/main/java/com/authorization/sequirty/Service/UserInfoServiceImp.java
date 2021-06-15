package com.example.appbackendapi.Service;

import com.example.appbackendapi.Entity.User;
import com.example.appbackendapi.Model.UserModel;
import com.example.appbackendapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserInfoServiceImp implements UserInfoService{

    private UserRepository userRepository;

    @Autowired
    public UserInfoServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUser(){
        Iterable<User> data = userRepository.findAll();
        List<UserModel> users = new LinkedList<>();
        data.forEach(user -> {
            users.add(new UserModel(user.getUsername(), user.getPassword(), user.getRole()));
       });
//        List<User> users = StreamSupport
//          .stream(userRepository.findAll().spliterator(), false)
//          .collect(Collectors.toList());

        return users;
    }
}

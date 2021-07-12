package com.authorization.sequirty.Service;

import com.authorization.sequirty.Entity.User;
import com.authorization.sequirty.Model.UserModel;
import com.authorization.sequirty.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

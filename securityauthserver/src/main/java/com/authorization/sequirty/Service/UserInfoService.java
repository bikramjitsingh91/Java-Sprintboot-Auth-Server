package com.example.appbackendapi.Service;

import com.example.appbackendapi.Entity.User;
import com.example.appbackendapi.Model.UserModel;

import java.util.List;

public interface UserInfoService {
    List<UserModel> getAllUser();
}

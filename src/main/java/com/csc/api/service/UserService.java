package com.csc.api.service;

import com.csc.api.model.entity.UserInfo;
import com.csc.api.model.request.UserRequest;

import java.util.List;

public interface UserService {
    Integer AddNewUser(UserRequest userRequest);
    List<UserInfo> getAllUsers();
}

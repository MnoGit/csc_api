package com.csc.api.controller;

import com.csc.api.model.entity.UserInfo;
import com.csc.api.model.request.UserRequest;
import com.csc.api.model.response.UserResponse;
import com.csc.api.service.UserService;
import com.csc.api.service.serviceImp.UserServiceImp;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
//@SecurityRequirement(name = "bearer")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<UserResponse<UserInfo>> addNewUser(@RequestBody UserRequest userRequest){
        if(userService.AddNewUser(userRequest) != null){
            UserResponse<UserInfo> response = UserResponse.<UserInfo>builder()
                    .message("Add success")
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;
    }
    @GetMapping("/all")
    public ResponseEntity<UserResponse<List<UserInfo>>> getAllUser(){
        if(userService.getAllUsers() !=  null){
            UserResponse<List<UserInfo>> response = UserResponse.<List<UserInfo>>builder()
                    .message("success")
                    .payload(userService.getAllUsers())
                    .build();
            return ResponseEntity.ok(response);
        }
        return null;
    }
}

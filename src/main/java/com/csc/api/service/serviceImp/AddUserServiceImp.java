package com.csc.api.service.serviceImp;

import com.csc.api.model.entity.UserInfo;
import com.csc.api.model.request.UserRequest;
import com.csc.api.repository.UserRepository;
import com.csc.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddUserServiceImp implements UserService {
    private final UserRepository userRepository;
    private  final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Integer AddNewUser(UserRequest userRequest) {
        String hashedPassword = passwordEncoder.encode(userRequest.getPassword());
        userRequest.setPassword(hashedPassword);
        Integer addNewUser = userRepository.saveUser(userRequest);
        return addNewUser;
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userRepository.findAllUser();
    }
}

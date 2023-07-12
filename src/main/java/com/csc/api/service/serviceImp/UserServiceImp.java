package com.csc.api.service.serviceImp;

import com.csc.api.model.entity.UserInfo;
import com.csc.api.model.request.UserRequest;
import com.csc.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =userRepository.getUserByUserName(username);
        if (userInfo ==null){
            throw new UsernameNotFoundException("user not found");

        }
        return userInfo ;
    }
//    public UserInfo addNewUser(UserRequest userRequest){
//        boolean isRole = false;
//        UserInfo userInfo = modelMapper.map(userRequest,UserInfo.class);
//        userInfo.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//
//        for (Role role: Role.values()){
//            if(userRequest.getRole().equals(role.name())){
//                isRole = true;
//                break;
//            }
//        }
//        if(!isRole){
//            throw new RuntimeException();
//
//        }
//        return userRepository.saveUser(userInfo);
//    }
}

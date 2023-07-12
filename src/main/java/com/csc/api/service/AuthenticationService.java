package com.csc.api.service;

import com.csc.api.model.request.AuthenticationRequest;
import com.csc.api.model.response.AuthenticationResponse;
import com.csc.api.repository.UserRepository;
import com.csc.api.config.JwtAuthenticationFilter;
import com.csc.api.config.JwtUtil;
import com.csc.api.service.serviceImp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserServiceImp userServiceImp;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getName(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authenticationRequest.getName());

        System.out.println("User information : " + user);
        var jwtToken = jwtUtil.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }


}

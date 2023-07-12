package com.csc.api.controller;


import com.csc.api.model.request.AuthenticationRequest;
import com.csc.api.model.response.AuthenticationResponse;
import com.csc.api.service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(
            @RequestBody AuthenticationRequest authenticationRequest
    ){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }



}



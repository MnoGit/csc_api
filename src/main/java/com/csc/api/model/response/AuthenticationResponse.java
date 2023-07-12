package com.csc.api.model.response;
import lombok.*;
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AuthenticationResponse {
    private String token;
}

package com.csc.api.model.request;

import com.csc.api.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String name;
    private String password;
     private String email;
     private Role role;
}

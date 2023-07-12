package com.csc.api.model.entity;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo implements UserDetails {
    private Integer id;
    private UUID user_id;
  private String name;
  private String password;
  private String email;
  private String role;
//  private boolean is_admin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role.toUpperCase());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

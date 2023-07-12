package com.csc.api.config;

import com.csc.api.service.serviceImp.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private final UserServiceImp userServiceImp;
    private  final BCryptPasswordEncoder passwordEncoder;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
            DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userServiceImp);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(
                        (req) -> req.requestMatchers("/api/v1/authors/all").hasRole("ADMIN")
//                                .requestMatchers("/api/v1/authors/admin").hasRole("ADMIN")
//                                .requestMatchers("/api/v1/authors/user").hasRole("USER")
//                                .requestMatchers("/api/v1/users/add").hasRole("ADMIN")
                                .requestMatchers("/api/v1/super/**").permitAll()
                                .requestMatchers("/", "/v3/api-docs/**","/swagger-ui/**","/swagger-ui-html"
                                ,"/api/v1/users/home","/api/v1/register","/api/v1/auth/**"
                        ).permitAll()
                        .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();

    }
}

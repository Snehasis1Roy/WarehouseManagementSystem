package com.example.warehouse.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityCofig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable());

        //Authencate the end point as public or private
        //role base access .requestMatchers(""/warehouse).hasAuthority(UserRole.Admin.name())
        http.authorizeHttpRequests(auth->auth.requestMatchers("/users")
                .permitAll().anyRequest().authenticated());

             //type of atthentication to be use [httpBasic,FormLogin,AuthOlogin]
        http.formLogin(Customizer.withDefaults());

        //building
        return http.build();
    }

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
    }

}

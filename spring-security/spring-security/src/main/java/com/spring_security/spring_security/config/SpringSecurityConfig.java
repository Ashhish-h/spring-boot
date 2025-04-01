package com.spring_security.spring_security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig  {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails ashish = User.builder()
                .username("ashish")
                .password("{noop}ashish123")   // noop means data is stored as plain text
                .roles("EMPLOYEE")
                .build();

        UserDetails anjali = User.builder()
                .username("anjali")
                .password("{noop}anjali123")
                .roles("EMPLOYEE", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ashish, anjali);
    }

}

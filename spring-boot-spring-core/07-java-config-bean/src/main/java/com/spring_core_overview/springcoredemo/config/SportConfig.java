package com.spring_core_overview.springcoredemo.config;

import com.spring_core_overview.springcoredemo.common.Coach;
import com.spring_core_overview.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){ // here bean id will be the method name
        return new SwimCoach();
    }
}

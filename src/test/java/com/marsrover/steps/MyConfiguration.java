package com.marsrover.steps;

import com.marsrover.Rover;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {
    @Bean
    @Scope("cucumber-glue")
    public Rover rover() {
        System.out.println();
        return new Rover();

    }
}
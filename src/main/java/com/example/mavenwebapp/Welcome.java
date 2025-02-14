package com.example.mavenwebapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

@RestController
@RequestMapping("/")
public class Welcome {

    @GetMapping
    public String welcome() {
        String greeting = getGreeting();
        return greeting + ", Brendan, " + "Welcome to COMP367";
    }

    private String getGreeting() {
        int hour = LocalTime.now().getHour();
        return (hour < 12) ? "Good morning" : "Good afternoon";
    }
}

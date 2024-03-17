package com.example;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String greeting() {
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(LocalTime.of(18, 0))) {
            return "<html><head><title>Welcome</title></head><body>" +
                    "<h1>Good afternoon!</h1>" +
                    "<h2>Welcome to COMP367</h2>" +
                    "</body></html>";
        } else {
            return "<html><head><title>Welcome</title></head><body>" +
                    "<h1>Good evening!</h1>" +
                    "<h2>Welcome to COMP367</h2>" +
                    "</body></html>";
        }
    }
}


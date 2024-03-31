package com.example.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello Guys.";
    }

    @GetMapping("/home")
    public String sayHelloFromGithub() {
        return "Hello to all from my first OAuth Application";
    }
}

package org.example.springsecex.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Welcome to Home" + " Session ID: " + request.getSession().getId();
    }
}

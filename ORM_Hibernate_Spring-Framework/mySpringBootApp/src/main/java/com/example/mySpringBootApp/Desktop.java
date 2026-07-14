package com.example.mySpringBootApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Desktop implements Computer {
    public void onStart() {
        System.out.println("Desktop started");
    }
}


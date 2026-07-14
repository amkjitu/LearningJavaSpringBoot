package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public class Laptop implements Computer {
    public void onStart() {
        System.out.println("Laptop started");
    }
}


/*
* Autowired by Spring Framework
* @Autowired is used for automatic dependency injection in Spring Framework.
* It allows Spring to resolve and inject collaborating beans into your bean.
* It is call Field Injection also here Laptop is getting injected into Dev class by Spring Framework.
* */
package com.example.mySpringApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {
//    // 1. Create a field of Laptop class and annotate it with
//    private String name;
//    private String role;
//
//    public Dev() {
//        this.name = "Alien";
//        this.role = "Engineer";
//    }
//
//    public Dev(String name, String role) {
//        this.name = name;
//        this.role = role;
//    }
//    public void build() {
//        System.out.println("Application for " + name + " with role " + role);
//    }

    // 2. create Laptop class and annotate it with @Autowired to tell Spring Framework to inject the dependency of Laptop class into Dev class.
    private Laptop laptop;
    private String name;
    private String role;

//    // 2.1: Inject with Constructor
//    public Dev(Laptop laptop) {
//        this.laptop = laptop;
//        this.name = "Alien";
//        this.role = "Engineer";
//    }

    // 2.2: Inject with @Autowired Field Injection
    @Autowired
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

//    public Dev(String name, String role) {
//        this.name = name;
//        this.role = role;
//    }
    public void build() {
        System.out.println("Application for " + name + " with role " + role);
        laptop.onStart(); // we can call the laptop
    }
}

/*
* Autowired by Spring Framework
* @Autowired is used for automatic dependency injection in Spring Framework.
* It allows Spring to resolve and inject collaborating beans into your bean.
* We can inject by:
*  1. Constructor Injection (Default)
*  2. Field Injection
*  3. Setter Injection
*
* Note to remember:
*   How @Autowired know that which class it should be injected?
*   The answer is by the type of the class. If there are multiple classes of the same type, then we can use @Qualifier annotation to specify which class should be injected.
* */
package com.example.mySpringBootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
//    // 1. Create Laptop class with its properties
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

//    // 2. declare a Laptop class and annotate it with @Autowired to tell Spring Framework to inject the dependency of Laptop class into Dev class.
//    // 2.1: Inject with @Autowired Field Injection
//    //    @Autowired
//    private Laptop laptop;
//    private String name;
//    private String role;
//
////    // 2.2: Inject with Constructor [this is default and not needed to use annotation @Autowired]
////    public Dev(Laptop laptop) {
////        this.laptop = laptop;
////        this.name = "Alien";
////        this.role = "Engineer";
////    }
//
//    // 2.3: Inject with @Autowired Setter Injection
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }
//
////    public Dev(String name, String role) {
////        this.name = name;
////        this.role = role;
////    }
//    public void build() {
//        System.out.println("Application for " + name + " with role " + role);
//        laptop.onStart(); // we can call the laptop
//    }

    // 3. declare Computer class and annotate it with @Autowired to tell Spring Framework to inject the dependency of Computer class into Dev class.
    // Here we will learn that if Spring finds more than one types to inject it gets confused and gives compile error: "Could not autowire, there is more than one bean of Computer".

    // We can solve this in two ways:
    // 1. @Primary Annotation: This is given at that class which we want to inject by default. This is given at the class level.
    // 2. @Qualifier Annotation: This is given at the Setter Injection level. For exmaple: @Qualifier("desktop") as we want to inject Desktop class here. This is given at the method level. "lowercase"

    private Computer computer;
    private String name;
    private String role;

    // 2.3: Inject with @Autowired Setter Injection
    @Autowired
    @Qualifier("desktop") // This is given at the method level.
    public void setLaptop(Computer computer) {
        this.computer = computer;
    }

    //    public Dev(String name, String role) {
//        this.name = name;
//        this.role = role;
//    }
    public void build() {
        System.out.println("Dev Doer " + name + " with role " + role);
        computer.onStart(); // we can call the computer
    }
}

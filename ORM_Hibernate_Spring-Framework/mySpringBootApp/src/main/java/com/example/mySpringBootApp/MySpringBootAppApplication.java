/*
* When Spring Create Object
*
*|------------------------------|
*|    | _________________ |     |
*|    | ____      -----   |     |
*|    | |Obj| ... |Obj|   |     |
*|    | ----      -----   |     |
*|    |-------------------|     |
*|         IoE Container        |
*|______________________________|
*               JVM
*
* Spring creates objects inside IoE Container of the JVM.
* Which Objects of the class should be created is decided by the Spring IoE Container.
* Annotations help to do this in a very easier way, for example @Component
* But When we create objects using new keyword, it is created in the heap memory of JVM.
*
* Topics to Learn:
* Dependency Injection
* Inversion of Control
* Spring IoC Container
* Spring Annotations:
* - @Component:
* - @Autowired
* - @Primary
* - @Qualifier
* */

package com.example.mySpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MySpringBootAppApplication {

    public static void main(String[] args) {
        /// 1. Create Application Context
        ApplicationContext context = SpringApplication.run(MySpringBootAppApplication.class, args);

        /// 2. Tell spring to create object of Dev class and get it from the context
        Dev dev = context.getBean(Dev.class); // Injected Dependency here simply
        dev.build();
    }

}

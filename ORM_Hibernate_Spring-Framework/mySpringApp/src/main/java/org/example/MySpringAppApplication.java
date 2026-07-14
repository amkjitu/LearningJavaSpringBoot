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
* xml configuration of spring (where told which object should create spring. In spring boot we told it to that specific classes by using Annotations)
* Spring Bean: Every class that Spring manages is called Bean. Spring Bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
*
* */

package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringAppApplication {
    public static void main(String[] args) {
        // 0. create IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        // 1. No wiring
//        context.getBean("dev", Dev.class);
//
//        Dev dev = (Dev) context.getBean("dev");
//        dev.build();

        // 2. Autowiring
        context.getBean("dev2", Dev.class);

        Dev dev2 = (Dev) context.getBean("dev2");
        dev2.build();

    }
}

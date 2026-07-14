/*
* Now will do all these below works by simple Spring Framework not by the spring boot annotations.
* Following we actually did in the mySpringBootApp project but here we will do it in the mySpringApp project.
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
*
* HERE WE GO:
* In the case we have to create an xml called resources/spring.xml configuration in which all the beans are there.
* 1. Setter injection:  <property name="computer" ref="laptop"/> here name="computer" automatically finds setComputer
* 2. Constructor injection: <constructor-arg ref="laptop"/>
* */
package org.example;

public class Dev {

    private Computer computer;
    private String name;
    private String role;

//    // 2.1: Inject with Setter Injection
//    public void setComputer(Computer computer){
//        this.computer = computer;
//    }

//    // 2.2: Inject with Constructor Injection
//    public Dev(Computer computer) {
//        this.computer = computer;
//    }

    // 2.3 Inject for autowired by Spring Framework
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void build() {
        System.out.println("Dev Doer " + name + " with role " + role);
        computer.onStart(); // we can call the computer
    }

    public void setName(String name){
        this.name = name;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getName(){
        return this.name;
    }
    public String getRole(){
        return this.role;
    }
}

package org.example.springbootjdbcdemo;

import org.example.springbootjdbcdemo.model.Robot;
import org.example.springbootjdbcdemo.repo.RobotRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcDemoApplication {

    public static void main(String[] args) {

        //1. Create IoC Container
        ApplicationContext context = SpringApplication.run(SpringBootJdbcDemoApplication.class, args);

        //2. Create a robot object
        Robot robot = context.getBean(Robot.class);
        robot.setId(4);
        robot.setName("Robo4");
        robot.setPoints(400);
        System.out.println(robot.toString());

        //3. create a repo object
        RobotRepo robotRepo = context.getBean(RobotRepo.class);
        // robotRepo.save(robot);
        robotRepo.findAll().forEach(System.out::println);
        robotRepo.delete(3);
        robotRepo.findAll().forEach(System.out::println);
    }

}

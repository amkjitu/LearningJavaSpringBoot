package org.example.springbootrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RobotResource {

//    // 1. Create a method that returns a list of robots in memory storage. this is only for testing the http://localhost:8011/robots is working or not.
//    @RequestMapping("/robots")
//    public List<Robot> getRobots() {
//        List<Robot> robots = new ArrayList<>();
//
//        Robot r1 = new Robot();
//        r1.setId(1);
//        r1.setName("Robo1");
//        r1.setPoints(200);
//
//        Robot r2 = new Robot();
//        r2.setId(2);
//        r2.setName("Robo2");
//        r2.setPoints(200);
//
//        robots.add(r1);
//        robots.add(r2);
//
//        return robots;
//    }

    // 2. Now we will get the data from the database
    @Autowired
    RobotRepository repository;

    @GetMapping("/robots")
    public List<Robot> getRobots() {
        return (List<Robot>)repository.findAll();
    }


}

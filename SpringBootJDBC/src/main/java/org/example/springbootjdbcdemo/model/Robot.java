package org.example.springbootjdbcdemo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Robot {
    private int id;
    private String name;
    private int points;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    @Override
    public String toString() {
        System.out.println("Robot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + points +
                '}');
        return "";
    }
}

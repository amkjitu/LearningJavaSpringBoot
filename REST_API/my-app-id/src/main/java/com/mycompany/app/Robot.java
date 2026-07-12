package com.mycompany.app;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Robot {
    private int id;
    private String name;
    private int points;

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}

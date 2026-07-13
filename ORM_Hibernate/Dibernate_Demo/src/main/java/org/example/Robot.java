package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "robots") //telling the table name
public class Robot {
    @Id
    private int id;
//    @Column(name = "robot_name") telling the column name [default id as the variable name]
    private String name;
//    @Column(name = "robot_tech") telling the column name [default name as the variable name]
    private String tech;
//    @Column(name = "robot_points") telling the column name [default points as the variable name]
    private int points;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTech() {
        return tech;
    }

    public int getPoints() {
        return points;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", points=" + points +
                '}';
    }
}

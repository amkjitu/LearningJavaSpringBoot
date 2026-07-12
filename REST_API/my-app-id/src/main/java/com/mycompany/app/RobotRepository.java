package com.mycompany.app;

import com.mycompany.app.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RobotRepository {

//    // Phase 1: We use memory storage to store robot data.
//    private static final List<Robot> robots = new ArrayList<>();
//
//    public RobotRepository(){
//        if (robots.isEmpty()) {
//            Robot r1 = new Robot();
//            r1.setId(1);
//            r1.setName("Robo1");
//            r1.setPoints(200);
//
//            Robot r2 = new Robot();
//            r2.setId(2);
//            r2.setName("Robo2");
//            r2.setPoints(200);
//
//            robots.add(r1);
//            robots.add(r2);
//        }
//    }
//
//    // All Robots
//    public List<Robot> getRobots() {
//
//        return robots;
//
//    }
//
//    // Specific Robot
//    public Robot getRobot(int id) {
//        for(Robot r: robots) {
//            if(r.getId() == id) {
//                return r;
//            }
//        }
//        return null;
//    }
//
//
//    public void createRobot(Robot robot) {
//        robots.add(robot);
//
//    }
//
//    public void updateRobot(int id, Robot robot) {
//        Robot existingRobot = getRobot(id);
//        if (existingRobot != null) {
//            existingRobot.setId(id);
//            existingRobot.setName(robot.getName());
//            existingRobot.setPoints(robot.getPoints());
//        }
//    }
//
//    public boolean deleteRobot(int id) {
//        return robots.removeIf(robot -> robot.getId() == id);
//    }

    // Phase 2: We will use database storage to store robot data. for this we here created util.JdbcUtil.java
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public RobotRepository() {
        try {
            connection = JdbcUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // get all robots
    public List<Robot> getRobots() throws SQLException {
        List<Robot> robots = new ArrayList<>();

        String getRobotsSQLQuery = "SELECT * FROM robotinfo";
        try {
            pstmt = connection.prepareStatement(getRobotsSQLQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Robot robot = new Robot();
                robot.setId(rs.getInt("id"));
                robot.setName(rs.getString("name"));
                robot.setPoints(rs.getInt("points"));
                robots.add(robot);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.closeConnection(connection, pstmt, rs);
        }
        return robots;
    }

    // Specific Robot
    public Robot getRobot(int id) {
        Robot robot = null;
        String getRobotSQLQuery = "SELECT * FROM robotinfo WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(getRobotSQLQuery);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                robot = new Robot();
                robot.setId(rs.getInt("id"));
                robot.setName(rs.getString("name"));
                robot.setPoints(rs.getInt("points"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.closeConnection(connection, pstmt, rs);
        }
        return robot;
    }

    // create robot
    public void createRobot(Robot robot) {
        String createRobotSQLQuery = "INSERT INTO robotinfo (name, points) VALUES (?, ?)";
        try {
            pstmt = connection.prepareStatement(createRobotSQLQuery);
            pstmt.setString(1, robot.getName());
            pstmt.setInt(2, robot.getPoints());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.closeConnection(connection, pstmt, null);
        }
    }

    // update robot
    public void updateRobot(int id, Robot robot) {
        String updateRobotSQLQuery = "UPDATE robotinfo SET name = ?, points = ? WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(updateRobotSQLQuery);
            pstmt.setString(1, robot.getName());
            pstmt.setInt(2, robot.getPoints());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.closeConnection(connection, pstmt, null);
        }
    }

    // delete robot
    public boolean deleteRobot(int id) {
        String deleteRobotSQLQuery = "DELETE FROM robotinfo WHERE id = ?";
        try {
            pstmt = connection.prepareStatement(deleteRobotSQLQuery);
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.closeConnection(connection, pstmt, null);
        }
    }
}

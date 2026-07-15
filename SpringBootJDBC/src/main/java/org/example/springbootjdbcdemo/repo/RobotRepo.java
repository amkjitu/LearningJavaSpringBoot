package org.example.springbootjdbcdemo.repo;

import org.example.springbootjdbcdemo.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RobotRepo {

    // 1. Initialize JDBC Template
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    // 2. Tell Spring to create the object of jdbcTemplate.
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 3. Create
    public void save(Robot robot) {
        String sql = "INSERT INTO robot (id, name, points) VALUES (?,?,?)";
        jdbcTemplate.update(sql, robot.getId(), robot.getName(), robot.getPoints());
    }

    // 4. Select All
    public List<Robot> findAll() {
        String sql = "SELECT * FROM robot";

        RowMapper<Robot> rowMapper = new RowMapper<Robot>() {
            public Robot mapRow(ResultSet rs, int rowNum) throws SQLException {
                Robot robot = new Robot();
                robot.setId(rs.getInt("id"));
                robot.setName(rs.getString("name"));
                robot.setPoints(rs.getInt("points"));
                return robot;
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    // 5. Delete
    public void delete(int id) {
        String sql = "DELETE FROM robot WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

}

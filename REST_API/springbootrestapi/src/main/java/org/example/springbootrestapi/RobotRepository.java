/*
CrudRepository<Robot,Integer>
Robot is the table name(entity class) and Integer is the primary key type of the table.
In the database there should be 'robot' table and this must match
* */
package org.example.springbootrestapi;

import org.springframework.data.repository.CrudRepository;
public interface RobotRepository extends CrudRepository<Robot,Integer> {

}

/*
1. @Consumes (What the API Accepts)
This annotation defines the format of the data the client sends to your API (in the HTTP Request Body).
* @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) means your endpoint is flexible. It tells the server that it can accept data formatted as either JSON or XML.
* If a client tries to send data as text/plain or application/x-www-form-urlencoded, the server will reject it and return an HTTP 415 Unsupported Media Type error.

2. @Produces (What the API Returns)
This annotation defines the format of the data your API sends back to the client (in the HTTP Response Body).
* @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) means your endpoint is capable of generating either JSON or XML responses.
* The server decides which one to send based on Content Negotiation. It looks at the Accept header sent by the client's HTTP request:
    * If the client sends Accept: application/json, your API will respond with JSON.
    * If the client sends Accept: application/xml, your API will respond with XML.
    * If the client doesn't specify or accepts both, the server will pick its default (usually the first one listed: JSON).
Full Code ExampleHere is how these look on a practical JAX-RS Resource class:
```
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @POST
    // 1. Tell the server we can receive JSON or XML from the client
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    // 2. Tell the server we can return JSON or XML back to the client
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createUser(User user) {
        // Business logic to save the user...

        // Returns the created user object.
        // JAX-RS automatically converts this Java object into JSON or XML
        return Response.status(Response.Status.CREATED).entity(user).build();
    }
}
```

Summary of Client/Server Communication:
* Client Sends (Request):
    * Content-Type: application/json → Matched by @Consumes
    * Accept: application/xml → Matched by @Produces
* Server Responds:
    * Returns the data formatted as XML because the client asked for it via the Accept header.
*/
package com.mycompany.app;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Path("robotresource")
public class RobotResource {
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
// 1. simple objects of Robot array
//    public List<Robot> getRobot(){
//        Robot r1 = new Robot();
//        r1.setName("Robo1");
//        r1.setPoints(100);
//
//        Robot r2 = new Robot();
//        r2.setName("Robo2");
//        r2.setPoints(200);
//        List<Robot> robots = Arrays.asList(r1, r2);
//
//        return robots;
//    }

    // // Phase 1 using memory storage
////    2. Now we will use the RobotRepository class to get the list of robots
//    @GET
//    @Path("robots")
//    @Produces(MediaType.APPLICATION_XML)
////    @Produces(MediaType.APPLICATION_JSON)
//    public List<Robot> getRobots(){
//        RobotRepository robotRepository = new RobotRepository();
//        return robotRepository.getRobots();
//    }
//
//    // 3. Get a specific robot by ID with content negotiation, this means based on user requirement we can return either XML or JSON for this @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) is set as an array that is defined.
//    @GET
////    @Produces(MediaType.APPLICATION_XML)
////    @Produces(MediaType.APPLICATION_JSON)
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Path("robot/{id}")
//    public Robot getRobot(@PathParam("id") int id){
//        RobotRepository robotRepository = new RobotRepository();
//        return robotRepository.getRobot(id);
//    }
//    // 4. Create a new robot
//    @POST
//    @Path("robot")
//    public Robot createRobot(Robot robot){
//        RobotRepository robotRepository = new RobotRepository();
//        robotRepository.createRobot(robot);
//        return robot;
//    }
//
//    // 5. Update an existing robot
//    @PUT
//    @Path("robot/{id}")
//    public Robot updateRobot(@PathParam("id") int id, Robot robot){
//        RobotRepository robotRepository = new RobotRepository();
//        robotRepository.updateRobot(id, robot);
//        return robot;
//    }
//
//    // 6. Delete a robot
//    @DELETE
//    @Path("robot/{id}")
//    public boolean deleteRobot(@PathParam("id") int id){
//        RobotRepository robotRepository = new RobotRepository();
//        return robotRepository.deleteRobot(id);
//    }

    // Phase 2 using real database
    // 2. Now we will use the RobotRepository class to get the list of robots
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("robots")
    //    @Produces(MediaType.APPLICATION_JSON)
    public List<Robot> getRobots() throws SQLException {
        RobotRepository robotRepository = new RobotRepository();
        return robotRepository.getRobots();
    }

    // 3. Get a specific robot by ID with content negotiation, this means based on user requirement we can return either XML or JSON for this @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) is set as an array that is defined.
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("robot/{id}")
    public Robot getRobot(@PathParam("id") int id){
        RobotRepository robotRepository = new RobotRepository();
        return robotRepository.getRobot(id);
    }
    // 4. Create a new robot
    @POST
    @Path("robot")
    public Robot createRobot(Robot robot){
        RobotRepository robotRepository = new RobotRepository();
        robotRepository.createRobot(robot);
        return robot;
    }

    // 5. Update an existing robot
    @PUT
    @Path("robot/{id}")
    public Robot updateRobot(@PathParam("id") int id, Robot robot){
        RobotRepository robotRepository = new RobotRepository();
        robotRepository.updateRobot(id, robot);
        return robot;
    }

    // 6. Delete a robot
    @DELETE
    @Path("robot/{id}")
    public boolean deleteRobot(@PathParam("id") int id){
        RobotRepository robotRepository = new RobotRepository();
        return robotRepository.deleteRobot(id);
    }
}

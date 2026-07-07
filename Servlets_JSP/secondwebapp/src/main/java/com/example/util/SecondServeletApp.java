/*
 1. Servlet: Servlet is a Java programming language class that is used to extend the capabilities of servers that host applications accessed by means of a request-response programming model. Although servlets can respond to any types of requests, they are commonly used to extend the applications hosted by web servers. Such web servlets are the Java counterpart to other dynamic web content technologies such as PHP and ASP.NET.
 Here we will see how servlet works and how to create a servlet and deploy it on a server. We will also see how to handle HTTP requests and responses using servlets.

 2. How to redirect to jsp/html page:
 Here we created simple HTML form and send the data to servlet using POST method. The servlet will receive the data and display it on the browser.
 Note: Servlet is Controller.
*/
package com.example.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet("/firstServlet")
public class SecondServeletApp extends HttpServlet {
    // This class can be used to define servlet methods like doGet, doPost, etc.

    public SecondServeletApp() {
        // Default constructor
        System.out.println("Servlet object is created internally by the container");
    }

    // 1. Handle POST requests: 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String usercity = request.getParameter("usercity");

//        // 1.1:
//        PrintWriter writer = response.getWriter();
//        writer.println("<html><body>");
//        writer.println("<h1>Welcome, " + username + " from " + usercity + "!</h1>");
//        writer.println("</body></html>");
//        writer.close();

         //1.2: Redirect to another servlet
         response.sendRedirect("./register.jsp?username=" + username + "&usercity=" + usercity);
    }

    // // 2. Handle GET requests: shows in the url bar: http://localhost:8080/secondwebapp/firstServlet?username=John&usercity=NewYork
    // public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     String username = request.getParameter("username");
    //     String usercity = request.getParameter("usercity");

    //     // PrintWriter writer = response.getWriter();
    //     // writer.println("<html><body>");
    //     // writer.println("<h1>Welcome, " + username + " from " + usercity + "!</h1>");
    //     // writer.println("</body></html>");
    //     // writer.close();
    // }

}

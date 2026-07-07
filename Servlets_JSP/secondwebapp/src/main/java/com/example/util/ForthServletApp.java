/*
 * Service (Servlet):
 * - service(HttpServletRequest req, HttpServletResponse res) runs once per request.
 * - The servlet container calls service() after init() and before destroy().
 * - In HttpServlet, service() checks HTTP method and delegates:
 *   GET  -> doGet()
 *   POST -> doPost()
 *   PUT  -> doPut()
 *   DELETE -> doDelete()
 * - In practice, we usually override doGet()/doPost() instead of service().

 * Now here we will see how to forward the request from one servlet to another servlet using RequestDispatcher. We will create two servlets, secondServlet and thirdServlet.

 */

package com.example.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/thirdServlet")
public class ForthServletApp extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Message
//        PrintWriter writer = response.getWriter();
//        writer.println("<h1>Response from thirdServlet</h1>");

        // 2. get the data from session
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        String usercity = (String) session.getAttribute("usercity");

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Response from thirdServlet</h1>");
        writer.println("<h2>Username: " + username + "</h2>");
        writer.println("<h2>User City: " + usercity + "</h2>");
        writer.close();


    }
}

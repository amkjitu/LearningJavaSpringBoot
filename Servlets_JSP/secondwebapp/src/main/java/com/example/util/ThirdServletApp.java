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

  3. How to forward one servlet to another:
  Now here we will see how to forward the request from one servlet to another servlet using RequestDispatcher. We will create two servlets, secondServlet and thirdServlet.
  4. How to pass the data also when forwarding to another servlet: We have to use Session for this purpose.
  Here from the index.html we have username and usercity these data will be sent also when forwarding
 * hit the http://localhost:8085/secondwebapp_war_exploded/secondServlet

 */

package com.example.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

@WebServlet("/secondServlet")
public class ThirdServletApp extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Control in secondServlet");

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/thirdServlet");
//        // 1. forward: it means only forward the control to the targeted servlet.
//        dispatcher.forward(request, response);
//
//        // 2. include: it means this controller will send the response of its own also to the targeted servlet. So, the response will be from both the servlets.
//        dispatcher.include(request, response);
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<h1>Response from secondServlet</h1>");
//        writer.close();
//
//        System.out.println("Control back in secondServlet after forwarding to thirdServlet");


        // 3. pass the data also
        RequestDispatcher dispatcher = request.getRequestDispatcher("/thirdServlet");
        String username = request.getParameter("username");
        String usercity = request.getParameter("usercity");

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10);
        session.setAttribute("username", username);
        session.setAttribute("usercity", usercity);
        dispatcher.forward(request,response);



    }
}

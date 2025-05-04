/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author GIGA STORE
 */
@WebServlet(name = "RouteController", urlPatterns = {"/Route"})
public class RouteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = request.getParameter("page");

if (page != null && !page.trim().isEmpty()) {
    String destination = page + ".jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
    dispatcher.forward(request, response);
} else {
    response.sendRedirect("login.jsp");
}

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

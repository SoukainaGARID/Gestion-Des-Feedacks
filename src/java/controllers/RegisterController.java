/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author GIGA STORE
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client newClient = new Client();
        newClient.setNom(nom);
        newClient.setEmail(email);
        newClient.setPassword(password);

        if (userService.create(newClient)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", newClient.getIdUser());
            session.setAttribute("email", email);
            session.setAttribute("nom", nom);
            response.sendRedirect("clientHome.jsp");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }
}

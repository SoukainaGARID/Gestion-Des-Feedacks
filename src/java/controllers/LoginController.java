package controllers;

import entities.User;
import entities.Admin;
import entities.Client;
import services.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("mdp");

        User user = userService.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getIdUser());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("nom", user.getNom());

            if (user instanceof Admin) {
                response.sendRedirect("AdminHome"); // corrigé : fichier est à la racine
            } else if (user instanceof Client) {
                response.sendRedirect("clientHome"); // corrigé : fichier est à la racine
            } else {
                response.sendRedirect("index.html"); // en cas de rôle inconnu
            }
        } else {
            response.sendRedirect("login.jsp?error=1"); // corrigé : fichier à la racine
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Login controller that handles Admin and Client authentication";
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Feedback;
import entities.ProduitService;
import services.ProduitServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import services.FeedbackService;

/**
 *
 * @author GIGA STORE
 */
@WebServlet(name = "ClientController", urlPatterns = {"/clientHome"})

public class ClientController extends HttpServlet {

    private ProduitServiceService pss;

    @Override
    public void init() throws ServletException {
        pss = new ProduitServiceService();
    }

   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // Charger les produits
    List<ProduitService> produits = pss.findAll();
    request.setAttribute("produits", produits);
    HttpSession session = request.getSession(false);
if (session == null || session.getAttribute("id") == null) {
    response.sendRedirect("login.jsp");
    return;
}

    // Charger les feedbacks du client
    int clientId = (int) request.getSession().getAttribute("id");
    FeedbackService fs = new FeedbackService();
    List<Feedback> feedbacks = fs.findFeedbacksByClient(clientId);
    request.setAttribute("feedbacksClient", feedbacks);

    // Forward après avoir tout mis dans request
    request.getRequestDispatcher("clientHome.jsp").forward(request, response);
}

}

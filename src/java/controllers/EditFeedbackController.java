/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Client;
import entities.Feedback;
import entities.FeedbackPK;
import entities.ProduitService;
import services.FeedbackService;
import services.ProduitServiceService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 *
 * @author GIGA STORE
 */
@WebServlet("/EditFeedbackController")
public class EditFeedbackController extends HttpServlet {

    private FeedbackService feedbackService;
    private ProduitServiceService produitService;

    @Override
    public void init() throws ServletException {
        feedbackService = new FeedbackService();
        produitService = new ProduitServiceService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int produitId = Integer.parseInt(request.getParameter("produitId"));
        int note = Integer.parseInt(request.getParameter("note"));
        String commentaire = request.getParameter("commentaire");

        HttpSession session = request.getSession();
        int clientId = (int) session.getAttribute("id");

        Feedback feedback = new Feedback();
        feedback.setId(new FeedbackPK(clientId, produitId));
        feedback.setNote(note);
        feedback.setCommentaire(commentaire);

        // Lier les entités nécessaires
        ProduitService produit = produitService.findById(produitId);
        Client client = new Client();
        client.setIdUser(clientId);

        feedback.setProduit(produit);
        feedback.setClient(client);

        feedbackService.update(feedback);

        response.sendRedirect("clientHome");
    }
}
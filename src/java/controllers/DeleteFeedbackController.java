/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entities.Feedback;
import entities.FeedbackPK;
import services.FeedbackService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author GIGA STORE
 */
@WebServlet("/DeleteFeedbackController")
public class DeleteFeedbackController extends HttpServlet {

    private FeedbackService feedbackService;

    @Override
    public void init() throws ServletException {
        feedbackService = new FeedbackService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int produitId = Integer.parseInt(request.getParameter("produitId"));
        int clientId = (int) request.getSession().getAttribute("id");

        FeedbackPK pk = new FeedbackPK(clientId, produitId);
        Feedback feedback = new Feedback();
        feedback.setId(pk);

        feedbackService.delete(feedback);

        response.sendRedirect("clientHome");
    }
}

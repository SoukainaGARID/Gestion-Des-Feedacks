/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Feedback;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.FeedbackService;

/**
 *
 * @author GIGA STORE
 */
@WebServlet("/getFeedbacksAjax")
public class GetFeedbacksController extends HttpServlet {

    private FeedbackService fs;

    @Override
    public void init() throws ServletException {
        fs = new FeedbackService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int produitId = Integer.parseInt(req.getParameter("id"));
        List<Feedback> feedbacks = fs.findFeedbacksByProduit(produitId);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (feedbacks == null || feedbacks.isEmpty()) {
            out.println("<p>Aucun feedback pour ce produit.</p>");
        } else {
            out.println("<div class='feedback-list'>");
            out.println("<h4>Feedbacks reçus :</h4>");
            for (Feedback f : feedbacks) {
                String noteColor;
                if (f.getNote() >= 8) {
                    noteColor = "green";
                } else if (f.getNote() >= 5) {
                    noteColor = "orange";
                } else {
                    noteColor = "red";
                }

                out.println("<div class='feedback-item' style='margin-bottom: 8px;'>");
                out.println("<strong>" + f.getClient().getNom() + "</strong> : " + f.getCommentaire());
                out.println(" <span style='color:" + noteColor + "; font-weight:bold;'>(" + f.getNote() + "/10)</span>");
                out.println("</div>");
            }
            out.println("</div>");
        }
    }
}

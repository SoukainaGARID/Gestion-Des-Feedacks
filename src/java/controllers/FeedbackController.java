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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FeedbackController", urlPatterns = {"/FeedbackController", "/getFeedbacks"})
public class FeedbackController extends HttpServlet {

    private FeedbackService feedbackService;
    private ProduitServiceService produitService;

    @Override
    public void init() throws ServletException {
        feedbackService = new FeedbackService();
        produitService = new ProduitServiceService();
    }

    // ✅Pour AJAX (admin) : GET feedbacks par produit
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam != null) {
            int produitId = Integer.parseInt(idParam);
            List<Feedback> feedbacks = feedbackService.findFeedbacksByProduit(produitId);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            if (feedbacks.isEmpty()) {
                out.println("<p>Aucun feedback pour ce produit.</p>");
            } else {
                out.println("<ul>");
                for (Feedback fb : feedbacks) {
                    out.println("<li><strong>Note:</strong> " + fb.getNote() + " | " +
                                "<strong>Commentaire:</strong> " + fb.getCommentaire() + "</li>");
                }
                out.println("</ul>");
            }
        }
    }

    //  Pour client : POST feedback
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int produitId = Integer.parseInt(request.getParameter("produitId"));
        int note = Integer.parseInt(request.getParameter("note"));
        String commentaire = request.getParameter("commentaire");

        HttpSession session = request.getSession();
        int clientId = (int) session.getAttribute("id");

        ProduitService produit = produitService.findById(produitId);
        Client client = new Client();
        client.setIdUser(clientId);

        Feedback feedback = new Feedback(commentaire, note, produit, client);
        feedback.setId(new FeedbackPK(clientId, produitId));

        feedbackService.create(feedback);

        response.sendRedirect("clientHome");
    }
}

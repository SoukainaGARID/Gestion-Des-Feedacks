package test;

import dao.FeedbackDao;
import entities.Feedback;
import java.util.List;

public class TestFeedbackProduit {
    public static void main(String[] args) {
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> feedbacks = dao.findFeedbacksByProduit(1); // Exemple: produit id 1

         System.out.println("Feedbacks d’un produit donné");
           
        for (Feedback f : feedbacks) {
            System.out.println("Client: " + f.getClient().getNom() +
                               ", Commentaire: " + f.getCommentaire() +
                               ", Note: " + f.getNote());
        }
    }
}

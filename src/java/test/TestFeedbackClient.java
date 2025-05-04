package test;

import dao.FeedbackDao;
import entities.Feedback;
import java.util.List;

public class TestFeedbackClient {
    public static void main(String[] args) {
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> feedbacks = dao.findFeedbacksByClient(2); // Exemple: client id 2
  System.out.println("Feedbacks d’un client spécifique");
        for (Feedback f : feedbacks) {
            System.out.println("Produit: " + f.getProduit().getNom() +
                               ", Commentaire: " + f.getCommentaire() +
                               ", Note: " + f.getNote());
        }
    }
}

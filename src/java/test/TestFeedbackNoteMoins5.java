package test;

import dao.FeedbackDao;
import entities.Feedback;
import java.util.List;

public class TestFeedbackNoteMoins5 {
    public static void main(String[] args) {
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> feedbacks = dao.findFeedbacksNoteLessThan5();
          System.out.println("feedback avec une note < 5");


        for (Feedback f : feedbacks) {
            System.out.println("Client: " + f.getClient().getNom() +
                               ", Produit: " + f.getProduit().getNom() +
                               ", Note: " + f.getNote());
        }
    }
}

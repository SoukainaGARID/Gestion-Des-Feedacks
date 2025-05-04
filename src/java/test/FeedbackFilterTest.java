package test;

import dao.FeedbackDao;
import dao.ClientDao;
import dao.ProduitServiceDao;
import dao.CategorieDao;
import entities.Client;
import entities.ProduitService;
import entities.Feedback;
import entities.Categorie;
import util.HibernateUtil;

import java.util.List;

public class FeedbackFilterTest {
    public static void main(String[] args) {
        FeedbackDao feedbackDao = new FeedbackDao();
        ClientDao clientDao = new ClientDao();
        ProduitServiceDao produitServiceDao = new ProduitServiceDao();
        CategorieDao categorieDao = new CategorieDao();

        // Données de test
        Categorie cat = new Categorie("TempCat");
        categorieDao.create(cat);

        ProduitService ps = new ProduitService("TempService", "Service", "Test description", cat);
        produitServiceDao.create(ps);

        Client c1 = new Client("Client1", "c1@example.com", "123");
        Client c2 = new Client("Client2", "c2@example.com", "123");
        clientDao.create(c1);
        clientDao.create(c2);

        Feedback f1 = new Feedback("Bien", 8, ps, c1);
        f1.updateCompositeKey();
        feedbackDao.create(f1);

        Feedback f2 = new Feedback("Pas terrible", 3, ps, c2);
        f2.updateCompositeKey();
        feedbackDao.create(f2);

     

        // 🔍 TEST 1: Feedbacks avec note < 5
        System.out.println("\n[Feedbacks avec note < 5]");
        List<Feedback> lowNotes = feedbackDao.findFeedbacksNoteLessThan5();
        for (Feedback fb : lowNotes) {
            System.out.println("- " + fb.getCommentaire() + " | Note : " + fb.getNote());
        }

        // 🔍 TEST 2: Feedbacks par produit
        System.out.println("\n[Feedbacks pour le produit : " + ps.getNom() + "]");
        List<Feedback> byProduit = feedbackDao.findFeedbacksByProduit(ps.getIdProduit());
        for (Feedback fb : byProduit) {
            System.out.println("- Client : " + fb.getClient().getNom() + " | Note : " + fb.getNote());
        }

        // 🔍 TEST 3: Feedbacks par client
        System.out.println("\n[Feedbacks donnés par le client : " + c1.getNom() + "]");
        List<Feedback> byClient = feedbackDao.findFeedbacksByClient(c1.getIdUser());
        for (Feedback fb : byClient) {
            System.out.println("- Produit : " + fb.getProduit().getNom() + " | Note : " + fb.getNote());
        }

        // Nettoyage
        //feedbackDao.delete(f1);
       // feedbackDao.delete(f2);
       // feedbackDao.delete(f3);
       // produitServiceDao.delete(ps);
      //  categorieDao.delete(cat);
       // clientDao.delete(c1);
      //  clientDao.delete(c2);

        HibernateUtil.getSessionFactory().close();
    }
}

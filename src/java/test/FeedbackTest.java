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

public class FeedbackTest {
    public static void main(String[] args) {
        FeedbackDao feedbackDao = new FeedbackDao();
        ClientDao clientDao = new ClientDao();
        ProduitServiceDao produitServiceDao = new ProduitServiceDao();
        CategorieDao categorieDao = new CategorieDao();

        // Créer un client
        Client client = new Client("Feedback Client", "feedback@example.com", "feedbackpass");
        clientDao.create(client);

        // Créer une catégorie
        Categorie categorie = new Categorie("Formation");
        categorieDao.create(categorie);

        // Créer un produit/service
        ProduitService ps = new ProduitService("Formation Java", "Service", "Cours Java avancé", categorie);
        produitServiceDao.create(ps);

        // Create Feedback
       Feedback feedback = new Feedback("Très bon cours", 9, ps, client);
       feedback.updateCompositeKey(); // OBLIGATOIRE avant de créer
       feedbackDao.create(feedback);
        System.out.println("Feedback created");

        // FindAll
        List<Feedback> feedbacks = feedbackDao.findAll();
        System.out.println("Total feedbacks: " + feedbacks.size());

        // Update
        feedback.setNote(8);
        feedbackDao.update(feedback);
        System.out.println("Updated feedback note");

        // Delete
        feedbackDao.delete(feedback);
        System.out.println("Feedback deleted");

        // Nettoyage des données créées
        produitServiceDao.delete(ps);
        categorieDao.delete(categorie);
        clientDao.delete(client);

        HibernateUtil.getSessionFactory().close();
    }
}

package test;

import entities.Client;
import entities.Feedback;
import entities.FeedbackPK;
import entities.ProduitService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FeedbackTestInsert {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // 7 clients dans la base
            List<Integer> clientIds = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
            // 10 produits (ids 1 à 10)
            int totalProduits = 10;

            // Commentaires variés
            List<String> commentaires = Arrays.asList(
                    "Très efficace, je recommande !",
                    "Odeur agréable et texture légère.",
                    "Résultats visibles en quelques jours.",
                    "Un peu cher, mais fonctionne bien.",
                    "Pas mal, mais pas exceptionnel.",
                    "Ma peau l'adore.",
                    "Je suis déçu, pas d'effet notable.",
                    "Bon produit, mais packaging à revoir.",
                    "Parfait pour ma routine quotidienne.",
                    "Je rachèterai sans hésiter."
            );

            Random rand = new Random();
            int commentaireIndex = 0;

            for (int produitId = 1; produitId <= totalProduits; produitId++) {
                // Choisir 4 clients aléatoires différents
                List<Integer> shuffledClients = clientIds.subList(0, 4 + rand.nextInt(2)); // 4 à 5 feedbacks

                for (Integer clientId : shuffledClients) {
                    ProduitService produit = (ProduitService) session.get(ProduitService.class, produitId);
                    Client client = (Client) session.get(Client.class, clientId);

                    int note = 5 + rand.nextInt(6); // notes entre 5 et 10
                    String commentaire = commentaires.get(commentaireIndex % commentaires.size());
                    commentaireIndex++;

                    Feedback fb = new Feedback(commentaire, note, produit, client);
                    fb.setId(new FeedbackPK(clientId, produitId));

                    session.save(fb);
                }
            }

            tx.commit();
            System.out.println("✔ Tous les produits ont reçu au moins 4 feedbacks.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

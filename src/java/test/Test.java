package test;

import dao.AdminDao;
import dao.ClientDao;
import dao.CategorieDao;
import dao.ProduitServiceDao;
import dao.FeedbackDao;
import entities.Admin;
import entities.Client;
import entities.Categorie;
import entities.ProduitService;
import entities.Feedback;
import util.HibernateUtil;

public class Test {

    public static void main(String[] args) {
        // Initialisation des DAO
        AdminDao adminDao = new AdminDao();
        ClientDao clientDao = new ClientDao();
        CategorieDao categorieDao = new CategorieDao();
        ProduitServiceDao produitServiceDao = new ProduitServiceDao();
        FeedbackDao feedbackDao = new FeedbackDao();

        // Création d'une catégorie
        Categorie cat1 = new Categorie();
        cat1.setNom("Informatique");
        categorieDao.create(cat1);

        // Création de produits/services
        ProduitService produit1 = new ProduitService();
        produit1.setNom("Formation Java");
        produit1.setType("Service");
        produit1.setDescription("Formation avancée en Java");
        produit1.setCategorie(cat1);
        produitServiceDao.create(produit1);

        ProduitService produit2 = new ProduitService();
        produit2.setNom("Formation AI");
        produit2.setType("Service");
        produit2.setDescription("Formation avancée en AI");
        produit2.setCategorie(cat1);
        produitServiceDao.create(produit2);

        // Création de clients
        Client client1 = new Client();
        client1.setNom("Soukaina");
        client1.setEmail("soukaina@example.com");
        client1.setPassword("123456");
        clientDao.create(client1);

        Client client2 = new Client();
        client2.setNom("Sara");
        client2.setEmail("sara@example.com");
        client2.setPassword("78900");
        clientDao.create(client2);

        Client client3 = new Client(); // Renommé pour éviter la confusion
        client3.setNom("Malak");
        client3.setEmail("malak@example.com");
        client3.setPassword("11111");
        clientDao.create(client3);

        // Création d'un admin
        Admin admin1 = new Admin();
        admin1.setNom("Admin");
        admin1.setEmail("admin@example.com");
        admin1.setPassword("adminpass");
        adminDao.create(admin1);

        // Ajout des feedbacks
        Feedback fb1 = new Feedback();
        fb1.setClient(client1);
        fb1.setProduit(produit1);
        fb1.setCommentaire("Super formation !");
        fb1.setNote(10);
        fb1.updateCompositeKey(); 
        feedbackDao.create(fb1);

        Feedback fb2 = new Feedback();
        fb2.setClient(client2);
        fb2.setProduit(produit2);
        fb2.setCommentaire("J'ai trop aimé !");
        fb2.setNote(6);
        fb2.updateCompositeKey(); 
        feedbackDao.create(fb2);

        Feedback fb3 = new Feedback();
        fb3.setClient(client3);
        fb3.setProduit(produit1);
        fb3.setCommentaire("Étudiante satisfaite !");
        fb3.setNote(9);
        fb3.updateCompositeKey(); 
        feedbackDao.create(fb3);

        Feedback fb4 = new Feedback();
        fb4.setClient(client3);
        fb4.setProduit(produit2);
        fb4.setCommentaire("J'ai pas bien compris !");
        fb4.setNote(4);
        fb4.updateCompositeKey(); 
        feedbackDao.create(fb4);

        // Message final
        System.out.println("Données de test ajoutées avec succès !");

        // Bonne pratique : fermer la session Hibernate
        HibernateUtil.getSessionFactory().close();
    }
}

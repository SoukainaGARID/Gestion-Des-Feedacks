package test;

import dao.ProduitServiceDao;
import dao.CategorieDao;
import entities.Categorie;
import entities.ProduitService;
import util.HibernateUtil;
import java.util.List;

public class ProduitServiceTest {
    public static void main(String[] args) {
        ProduitServiceDao produitServiceDao = new ProduitServiceDao();
        CategorieDao categorieDao = new CategorieDao();

        // Créer une catégorie pour l'associer au produit/service
        Categorie categorie = new Categorie("Services Informatiques");
        categorieDao.create(categorie);

        // Create ProduitService
        ProduitService ps = new ProduitService("Support Technique", "Service", "Assistance technique 24/7", categorie);
        produitServiceDao.create(ps);
        System.out.println("ProduitService created with ID: " + ps.getIdProduit());

        // FindById
        ProduitService p = produitServiceDao.findById(ps.getIdProduit());
        System.out.println("Found produitService: " + (p != null ? p.getNom() : "Not Found"));

        // Update
        p.setNom("Support Technique Premium");
        produitServiceDao.update(p);
        System.out.println("Updated produitService name: " + produitServiceDao.findById(p.getIdProduit()).getNom());

        // FindAll
        List<ProduitService> produitServices = produitServiceDao.findAll();
        System.out.println("Total produitServices: " + produitServices.size());

        // Delete
        produitServiceDao.delete(p);
        System.out.println("ProduitService deleted: " + (produitServiceDao.findById(p.getIdProduit()) == null ? "Success" : "Fail"));

        // Nettoyer la catégorie créée
        categorieDao.delete(categorie);

        HibernateUtil.getSessionFactory().close();
    }
}

package test;

import dao.CategorieDao;
import entities.Categorie;
import util.HibernateUtil;
import java.util.List;

public class CategorieTest {
    public static void main(String[] args) {
        CategorieDao categorieDao = new CategorieDao();

        // Create
        Categorie categorie = new Categorie("Informatique");
        categorieDao.create(categorie);
        System.out.println("Categorie created with ID: " + categorie.getId());

        // FindById
        Categorie c = categorieDao.findById(categorie.getId());
        System.out.println("Found categorie: " + (c != null ? c.getNom() : "Not Found"));

        // Update
        c.setNom("Informatique Avancée");
        categorieDao.update(c);
        System.out.println("Updated categorie name: " + categorieDao.findById(c.getId()).getNom());

        // FindAll
        List<Categorie> categories = categorieDao.findAll();
        System.out.println("Total categories: " + categories.size());

        // Delete
        categorieDao.delete(c);
        System.out.println("Categorie deleted: " + (categorieDao.findById(c.getId()) == null ? "Success" : "Fail"));

        HibernateUtil.getSessionFactory().close();
    }
}

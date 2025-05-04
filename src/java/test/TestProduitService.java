/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.CategorieDao;
import dao.ProduitServiceDao;
import entities.Categorie;
import entities.ProduitService;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */
public class TestProduitService {
    public static void main(String[] args) {
        Categorie categorie = new Categorie("Informatique");
new CategorieDao().create(categorie);

ProduitService p1 = new ProduitService("Service A", "Support", "Assistance technique", categorie);
ProduitService p2 = new ProduitService("Service B", "Logiciel", "Application métier", categorie);
ProduitServiceDao produitDao = new ProduitServiceDao();
produitDao.create(p1);
produitDao.create(p2);

// Requête via named query
System.out.println("[Produits de la catégorie : " + categorie.getNom() + "]");
List<ProduitService> produits = produitDao.findByCategorieId(categorie.getId());
for (ProduitService ps : produits) {
    System.out.println("- " + ps.getNom() + " (" + ps.getType() + ")");
}

    
    }
    
}

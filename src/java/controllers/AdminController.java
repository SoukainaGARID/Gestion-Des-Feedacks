/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Categorie;
import entities.ProduitService;
import services.ProduitServiceService;
import services.FeedbackService;
import services.CategorieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GIGA STORE
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminHome"})
public class AdminController extends HttpServlet {

    private ProduitServiceService pss;
    private FeedbackService fs;
    private CategorieService categorieService;

    @Override
    public void init() throws ServletException {
        pss = new ProduitServiceService();
        fs = new FeedbackService();
        categorieService = new CategorieService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ProduitService> produits = pss.findAll();
        request.setAttribute("produits", produits);
        
        
         // Statistiques pour le dashboard
        int totalProduits = produits.size();
        int totalFeedbacks = fs.getTotalFeedbacks();
        double moyenneGenerale = fs.getGlobalAverageNote();

        request.setAttribute("totalProduits", totalProduits);
        request.setAttribute("totalFeedbacks", totalFeedbacks);
        request.setAttribute("moyenneGenerale", Math.round(moyenneGenerale * 10.0) / 10.0); // arrondi à 1 décimale

        // Catégories pour le formulaire d’ajout
        List<Categorie> categories = categorieService.findAll();
        request.setAttribute("categories", categories);

        // Moyennes des feedbacks
        Map<String, Double> notesMoyennes = new HashMap<>();
        for (ProduitService p : produits) {
            Double moyenne = fs.getAverageNoteByProduit(p.getIdProduit());
            notesMoyennes.put(p.getNom(), moyenne != null ? moyenne : 0.0);
        }
        request.setAttribute("notesMoyennes", notesMoyennes);
        String editIdParam = request.getParameter("editId");
        if (editIdParam != null && !editIdParam.isEmpty()) {
            int editId = Integer.parseInt(editIdParam);
            ProduitService produitAModifier = pss.findById(editId);
            request.setAttribute("produitEdit", produitAModifier);
        }
       

        request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        int idCategorie = Integer.parseInt(request.getParameter("categorie"));

        // Trouver la catégorie
        Categorie categorie = categorieService.findById(idCategorie);

        // Créer le produit
        ProduitService produit = new ProduitService();
        produit.setNom(nom);
        produit.setType(type);
        produit.setDescription(description);
        produit.setCategorie(categorie);

        // Sauvegarder
        pss.create(produit);

        HttpSession session = request.getSession();
        session.setAttribute("messageSucces", "Produit ajouté avec succès !");

        // Rediriger pour recharger les données
        response.sendRedirect("AdminHome?msg=success#listproducts");
    }
}

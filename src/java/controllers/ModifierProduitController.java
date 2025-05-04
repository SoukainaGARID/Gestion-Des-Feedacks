package controllers;

import entities.ProduitService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CategorieService;
import services.ProduitServiceService;

@WebServlet("/ModifierProduit")
public class ModifierProduitController extends HttpServlet {

    private final ProduitServiceService pss = new ProduitServiceService();
    private final CategorieService cs = new CategorieService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nom = req.getParameter("nom");
            String type = req.getParameter("type");
            String description = req.getParameter("description");
            int idCat = Integer.parseInt(req.getParameter("categorie"));

            ProduitService produit = pss.findById(id);
            if (produit != null) {
                produit.setNom(nom);
                produit.setType(type);
                produit.setDescription(description);
                produit.setCategorie(cs.findById(idCat));
                pss.update(produit);
                resp.sendRedirect("AdminHome?msg=modif#listproducts");
            } else {
                resp.sendRedirect("AdminHome?msg=notfound#listproducts");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("AdminHome?msg=error#listproducts");
        }
    }
}

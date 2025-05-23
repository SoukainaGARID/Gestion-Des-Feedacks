/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.ProduitService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProduitServiceService;

/**
 *
 * @author GIGA STORE
 */
@WebServlet("/SupprimerProduit")
public class SupprimerProduitController extends HttpServlet {
    private final ProduitServiceService produitService = new ProduitServiceService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProduitService produit = produitService.findById(id);

        if (produit != null) {
            produitService.delete(produit);
        }

        response.sendRedirect("AdminHome#listproducts");
    }
}


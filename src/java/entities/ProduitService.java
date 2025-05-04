/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 *
 * @author GIGA STORE
 */
@Entity

@NamedQuery(name = "findProduitsByCategorie", query = "from ProduitService p where p.categorie.id = :idCategorie")

public class ProduitService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    private String nom;
    private String type;
    private String description;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    public ProduitService() {
    }

    public ProduitService(String nom, String type, String description, Categorie categorie) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.categorie = categorie;
    }
    
    
    

    // Getters & setters

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
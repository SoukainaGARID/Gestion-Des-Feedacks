package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity

@NamedQueries({
    @NamedQuery(name = "findFeedbacksNoteLessThan5", query = "FROM Feedback f WHERE f.note < 5"),
    @NamedQuery(name = "findFeedbacksByProduit", query = "FROM Feedback f WHERE f.produit.idProduit = :idProduit"),
    @NamedQuery(name = "findFeedbacksByClient", query = "FROM Feedback f WHERE f.client.idUser = :idClient"),
    
})
public class Feedback implements Serializable {

    @EmbeddedId
    private FeedbackPK id;

    private String commentaire;
    private int note;

    @ManyToOne
    @JoinColumn(name = "produit", insertable = false, updatable = false)
    private ProduitService produit;

    @ManyToOne
    @JoinColumn(name = "client", insertable = false, updatable = false)
    private Client client;

    public Feedback() {
    }

    public Feedback( String commentaire, int note, ProduitService produit, Client client) {
      
        this.commentaire = commentaire;
        this.note = note;
        this.produit = produit;
        this.client = client;
    }

    public FeedbackPK getId() {
        return id;
    }

    public void setId(FeedbackPK id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public ProduitService getProduit() {
        return produit;
    }

    public void setProduit(ProduitService produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
public void updateCompositeKey() {
    if (client != null && produit != null) {
        this.id = new FeedbackPK(client.getIdUser(), produit.getIdProduit());
    }
}

}

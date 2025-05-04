package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class FeedbackPK implements Serializable {

    private int client;
    private int produit;

    public FeedbackPK() {
    }

    public FeedbackPK(int client, int produit) {
        this.client = client;
        this.produit = produit;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FeedbackPK)) return false;
        FeedbackPK that = (FeedbackPK) o;
        return client == that.client &&
               produit == that.produit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, produit);
    }
}

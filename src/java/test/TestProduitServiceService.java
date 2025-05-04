
import services.ProduitServiceService;
import entities.ProduitService;
import entities.Categorie;

public class TestProduitServiceService {

    public static void main(String[] args) {
        ProduitServiceService service = new ProduitServiceService();

        Categorie cat = new Categorie("TestCat");
        // Normalement tu dois d'abord créer la catégorie via CategorieService
        ProduitService produit = new ProduitService("TestProd", "Service", "Description", cat);

        // Create
        service.create(produit);

        // Read
        ProduitService found = service.findById(produit.getIdProduit());
        System.out.println("✅ Found: " + found.getNom());

        // Update
        produit.setNom("UpdatedProd");
        service.update(produit);

        // Read again
        ProduitService updated = service.findById(produit.getIdProduit());
        System.out.println("🔁 Updated: " + updated.getNom());

        // Delete
        service.delete(updated);
        System.out.println("🗑️ Deleted");
    }
}

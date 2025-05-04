
import services.CategorieService;
import entities.Categorie;

public class TestCategorieService {

    public static void main(String[] args) {
        CategorieService service = new CategorieService();

        Categorie cat = new Categorie("TestCat");

        // Create
        service.create(cat);

        // Read
        Categorie found = service.findById(cat.getId());
        System.out.println("✅ Found: " + found.getNom());

        // Update
        cat.setNom("UpdatedCat");
        service.update(cat);

        // Read again
        Categorie updated = service.findById(cat.getId());
        System.out.println("🔁 Updated: " + updated.getNom());

        // Delete
        service.delete(updated);
        System.out.println("🗑️ Deleted");
    }
}


import entities.Admin;
import entities.User;
import services.AdminService;
import services.UserService;

public class TestAdminService {
    public static void main(String[] args) {
        UserService userService = new UserService();
        AdminService adminService = new AdminService();

        User user = new User("admin@example.com", "Admin Test", "admin123");
        userService.create(user);

        Admin admin = new Admin();
        admin.setIdUser(user.getIdUser());
        adminService.create(admin);

        Admin found = adminService.findById(user.getIdUser());
        if (found != null) {
            System.out.println("✅ Admin trouvé avec ID: " + found.getIdUser());
        } else {
            System.out.println("❌ Admin non trouvé.");
        }

        adminService.delete(admin);
        userService.delete(user);
    }
}

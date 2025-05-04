package test;

import entities.User;
import services.UserService;
import util.HibernateUtil;

import java.util.List;

public class UserServiceTest {

    public static void main(String[] args) {

        UserService userService = new UserService();

        // 🔹 1. Create user
        User user = new User("Test User", "testuser@example.com", "testpass");
        boolean created = userService.create(user);
        System.out.println(created ? "✅ User created" : "❌ Failed to create user");

        // 🔹 2. Find by ID
        User found = userService.findById(user.getIdUser());
        System.out.println(found != null ? "✅ Found user: " + found.getNom() : "❌ User not found");

        // 🔹 3. Update user
        found.setNom("Updated User");
        boolean updated = userService.update(found);
        System.out.println(updated ? "🔁 Updated user: " + userService.findById(found.getIdUser()).getNom() : "❌ Failed to update");

        // 🔹 4. Find all
        List<User> users = userService.findAll();
        System.out.println("📋 Total users: " + users.size());
        
         // Recherche par email
        User founda = userService.findByEmail("testuser@example.com");
        if (founda != null) {
            System.out.println("🔍 Found user: " + founda.getNom() + " | Email: " + founda.getEmail());
        } else {
            System.out.println("❌ User not found.");
        }
  

        // 🔹 5. Delete user
        boolean deleted = userService.delete(found);
        System.out.println(deleted ? "🗑️ User deleted" : "❌ Failed to delete user");

        HibernateUtil.getSessionFactory().close();
    }
}

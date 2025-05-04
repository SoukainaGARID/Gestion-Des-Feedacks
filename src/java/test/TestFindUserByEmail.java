package test;

import dao.UserDao;
import entities.User;

public class TestFindUserByEmail {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // 1. Créer un nouvel utilisateur
        User newUser = new User();
        newUser.setEmail("testuser@example.com");
        newUser.setNom("Test User");
        newUser.setPassword("password123");

        // Sauvegarder l'utilisateur
        userDao.create(newUser);

        // 2. Rechercher par email
        User foundUser = userDao.findUserByEmail("testuser@example.com");

        if (foundUser != null) {
            System.out.println("✅ Utilisateur trouvé : " + foundUser.getNom());
        } else {
            System.out.println("❌ Utilisateur NON trouvé !");
        }
    }
}

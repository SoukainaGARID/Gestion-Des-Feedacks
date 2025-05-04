package test;

import entities.Client;
import entities.User;
import services.ClientService;
import services.UserService;

import java.util.List;

public class ClientServiceTest {

    public static void main(String[] args) {
        UserService userService = new UserService();
        ClientService clientService = new ClientService();

        // 1. Créer un utilisateur
        User user = new User();
        user.setNom("Test Client");
        user.setEmail("test.client@example.com");
        user.setPassword("1234");
        boolean userCreated = userService.create(user);
        System.out.println(userCreated ? "✅ User created" : "❌ Failed to create user");

        // 2. Créer un client lié à l'utilisateur
        Client client = new Client();
        client.setIdUser(user.getIdUser());  // Assure-toi que l'ID a été généré
        boolean clientCreated = clientService.create(client);
        System.out.println(clientCreated ? "✅ Client created" : "❌ Failed to create client");

       Client fetchedClient = clientService.findById(user.getIdUser());
if (fetchedClient == null) {
    System.out.println("❌ Client not found");
} else {
    System.out.println("✅ Client fetched");
    // Maintenant, tu peux faire update ou delete
    clientService.update(fetchedClient);
}

        // 5. Récupérer tous les clients
        List<Client> allClients = clientService.findAll();
        System.out.println("📋 Total clients: " + allClients.size());

        // 6. Supprimer
        boolean deleted = clientService.delete(fetchedClient);
        userService.delete(user); // Supprimer aussi l'utilisateur
        System.out.println(deleted ? "🗑️ Client deleted" : "❌ Delete failed");
    }
}

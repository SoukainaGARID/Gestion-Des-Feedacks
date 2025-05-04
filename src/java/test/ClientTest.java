package test;

import dao.ClientDao;
import entities.Client;
import util.HibernateUtil;
import java.util.List;

public class ClientTest {
    public static void main(String[] args) {
        ClientDao clientDao = new ClientDao();

        // Create
        Client client = new Client("Test Client", "testclient@example.com", "password");
        clientDao.create(client);
        System.out.println("Client created with ID: " + client.getIdUser());

        // FindById
        Client c = clientDao.findById(client.getIdUser());
        System.out.println("Found client: " + (c != null ? c.getNom() : "Not Found"));

        // Update
        c.setNom("Updated Client");
        clientDao.update(c);
        System.out.println("Updated client name: " + clientDao.findById(c.getIdUser()).getNom());

        // FindAll
        List<Client> clients = clientDao.findAll();
        System.out.println("Total clients: " + clients.size());

        // Delete
        clientDao.delete(c);
        System.out.println("Client deleted: " + (clientDao.findById(c.getIdUser()) == null ? "Success" : "Fail"));

        HibernateUtil.getSessionFactory().close();
    }
}

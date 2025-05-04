/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import dao.ClientDao;
import entities.Client;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */
public class ClientService implements IService<Client> {

    private final ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDao();
    }

    @Override
    public boolean create(Client o) {
        return clientDao.create(o);
    }

    @Override
    public boolean delete(Client o) {
        return clientDao.delete(o);
    }

    @Override
    public boolean update(Client o) {
        return clientDao.update(o);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Client findById(int id) {
        return clientDao.findById(id);
    }
}
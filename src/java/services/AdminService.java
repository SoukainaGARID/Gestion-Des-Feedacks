/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import dao.AdminDao;
import entities.Admin;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */


public class AdminService implements IService<Admin> {

    private final AdminDao adminDao;

    public AdminService() {
        this.adminDao = new AdminDao();
    }

    @Override
    public boolean create(Admin o) {
        return adminDao.create(o);
    }

    @Override
    public boolean delete(Admin o) {
        return adminDao.delete(o);
    }

    @Override
    public boolean update(Admin o) {
        return adminDao.update(o);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin findById(int id) {
        return adminDao.findById(id);
    }

    
}


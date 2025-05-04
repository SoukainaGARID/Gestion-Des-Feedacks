package test;

import dao.AdminDao;
import entities.Admin;
import util.HibernateUtil;
import java.util.List;

public class AdminTest {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();

        // Create
        Admin admin = new Admin("Test Admin", "admin@example.com", "adminpass");
        adminDao.create(admin);
        System.out.println("Admin created with ID: " + admin.getIdUser());

        // FindById
        Admin a = adminDao.findById(admin.getIdUser());
        System.out.println("Found admin: " + (a != null ? a.getNom() : "Not Found"));

        // Update
        a.setNom("Updated Admin");
        adminDao.update(a);
        System.out.println("Updated admin name: " + adminDao.findById(a.getIdUser()).getNom());

        // FindAll
        List<Admin> admins = adminDao.findAll();
        System.out.println("Total admins: " + admins.size());

        // Delete
        adminDao.delete(a);
        System.out.println("Admin deleted: " + (adminDao.findById(a.getIdUser()) == null ? "Success" : "Fail"));

        HibernateUtil.getSessionFactory().close();
    }
}

package services;

import dao.UserDao;
import entities.User;
import java.util.List;

public class UserService implements IService<User> {

    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    @Override
    public boolean create(User o) {
        return userDao.create(o);
    }

    @Override
    public boolean delete(User o) {
        return userDao.delete(o);
    }

    @Override
    public boolean update(User o) {
        return userDao.update(o);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

   
    public User findByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}

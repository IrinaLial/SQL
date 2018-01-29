package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    public void save(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.save(user);
    }

    public List<User> getAll() {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAll();
    }

    @Override
    public void update(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        UserDao userDao = new UserDaoImpl();
        userDao.delete(id);
    }
}

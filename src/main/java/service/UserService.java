package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

public class UserService {

    private UserDao userDao = new UserDaoImpl();

    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }

        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}

package service;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import model.Admin;

public class AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    public Admin login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }

        Admin admin = adminDao.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }

        return null;
    }
}

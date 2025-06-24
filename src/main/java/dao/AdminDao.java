package dao;

import model.Admin;

public interface AdminDao {
    Admin findByUsername(String username);
}

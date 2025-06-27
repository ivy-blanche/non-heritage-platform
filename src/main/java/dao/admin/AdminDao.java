package dao.admin;

import model.Admin;

public interface AdminDao {
    Admin findByUsername(String username);
}

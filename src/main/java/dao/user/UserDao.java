package dao.user;

import model.User;

public interface UserDao {
    // 根据用户名查找用户，返回 User 对象，找不到返回 null
    User findByUsername(String username);
}

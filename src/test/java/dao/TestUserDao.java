package dao;

import dao.impl.UserDaoImpl;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserDao {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void testFindByUsernameExists() {
        String username = "testuser"; // 请确保测试数据库中有这个用户名
        User user = userDao.findByUsername(username);
        assertNotNull(user, "应该查询到用户");
        assertEquals(username, user.getUsername(), "用户名应匹配");
        assertNotNull(user.getPassword(), "密码不应为空");
    }

    @Test
    public void testFindByUsernameNotExists() {
        String username = "non_existent_user";
        User user = userDao.findByUsername(username);
        assertNull(user, "不存在的用户名应返回null");
    }
}

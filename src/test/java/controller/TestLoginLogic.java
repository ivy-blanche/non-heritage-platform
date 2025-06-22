package controller;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginLogic {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 模拟登录验证逻辑
     */
    private boolean login(String inputUsername, String inputPassword) {
        User user = userDao.findByUsername(inputUsername);
        if (user == null) return false;
        return user.getPassword().equals(inputPassword);
    }

    @Test
    public void testLoginSuccess() {
        // 确保数据库中有该用户和密码
        assertTrue(login("testuser", "123456"), "用户名密码正确应登录成功");
    }

    @Test
    public void testLoginWrongPassword() {
        assertFalse(login("testuser", "wrongpass"), "密码错误应登录失败");
    }

    @Test
    public void testLoginUserNotExist() {
        assertFalse(login("not_exist", "123456"), "用户不存在应登录失败");
    }

    @Test
    public void testLoginEmptyInput() {
        assertFalse(login("", ""), "空用户名密码应登录失败");
    }

    @Test
    public void testLoginNullInput() {
        assertFalse(login(null, null), "null 用户名密码应登录失败");
    }
}

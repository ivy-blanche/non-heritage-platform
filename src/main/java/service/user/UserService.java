package service.user;

import dao.user.UserDao;
import dao.impl.user.UserDaoImpl;
import model.User;

/**
 * UserService 类
 * 负责处理用户相关的业务逻辑，如用户登录等
 */
public class UserService {

    // 持有用户数据访问对象，实现用户数据的操作
    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录方法
     * 根据用户名和密码验证用户身份
     *
     * @param username 用户名，不能为空
     * @param password 密码，不能为空
     * @return 验证成功返回对应User对象，失败返回null
     */
    public User login(String username, String password) {
        // 校验用户名和密码是否为空
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }

        // 根据用户名查询用户信息
        User user = userDao.findByUsername(username);

        // 如果用户存在且密码匹配，返回用户对象
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        // 验证失败返回null
        return null;
    }
}

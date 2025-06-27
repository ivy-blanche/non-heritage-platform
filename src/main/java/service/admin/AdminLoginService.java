package service.admin;

import dao.admin.AdminDao;
import dao.impl.admin.AdminDaoImpl;
import model.Admin;

/**
 * AdminService 类
 * 负责处理管理员相关的业务逻辑，如登录验证等
 */
public class AdminLoginService {

    // 数据访问对象，用于操作管理员数据表
    private AdminDao adminDao = new AdminDaoImpl();

    /**
     * 管理员登录方法
     * 根据用户名和密码验证管理员身份
     *
     * @param username 管理员用户名，不能为空
     * @param password 管理员密码，不能为空
     * @return 若验证成功，返回对应的 Admin 对象；否则返回 null
     */
    public Admin login(String username, String password) {
        // 校验用户名和密码是否为空
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }

        // 根据用户名查询管理员信息
        Admin admin = adminDao.findByUsername(username);

        // 验证密码是否匹配
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }

        // 登录失败，返回 null
        return null;
    }
}

package dao.impl.user;

import dao.user.UserDao;
import model.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDaoImpl 类
 * 实现 UserDao 接口，负责用户数据的数据库访问操作
 * <p>
 * 当前仅实现了通过用户名查找用户的方法
 */
public class UserDaoImpl implements UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 要查询的用户名
     * @return 若用户存在，返回包含用户名和密码的 User 对象；否则返回 null
     */
    @Override
    public User findByUsername(String username) {
        String sql = "SELECT username, password FROM user WHERE username = ?";

        try (
                // 获取数据库连接
                Connection conn = DBUtil.getConnection();
                // 预编译 SQL 语句
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            // 设置用户名参数
            ps.setString(1, username);

            // 执行查询
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // 如果查询结果存在，封装成 User 对象返回
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            }

        } catch (SQLException e) {
            // 打印异常堆栈信息
            e.printStackTrace();
        }

        // 用户不存在或查询失败时返回 null
        return null;
    }
}

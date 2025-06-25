package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类 DBUtil
 * 用于加载数据库配置文件并提供数据库连接方法

 * 功能说明：
 * - 读取 db.properties 配置文件，初始化 JDBC 连接参数
 * - 提供 getConnection() 方法统一获取数据库连接

 * 注意事项：
 * - 依赖 db.properties 文件，需放置在类路径下
 * - 使用 MySQL 驱动 com.mysql.cj.jdbc.Driver
 */
public class DBUtil {

    // JDBC 连接参数
    private static String url;
    private static String user;
    private static String password;

    // 静态代码块：类加载时读取配置文件并加载驱动
    static {
        try {
            Properties props = new Properties();
            // 从类路径中读取配置文件 db.properties
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(in);

            // 读取数据库连接配置
            url = props.getProperty("jdbc.url");
            user = props.getProperty("jdbc.username");
            password = props.getProperty("jdbc.password");

            // 加载 JDBC 驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return Connection 数据库连接对象
     * @throws SQLException 如果连接失败则抛出异常
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}

import java.sql.*;

public class PasswordEncodingTest {
    public static void main(String[] args) {
        // 修改为你实际的数据库连接信息
        String url = "jdbc:mysql://localhost:3306/db_heritage?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String password = "123456";

        String sql = "SELECT username, password FROM admin LIMIT 5";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String username = rs.getString("username");
                String pwd = rs.getString("password");

                System.out.println("用户名: " + username);
                System.out.println("密码字段原始值: " + pwd);

                // 打印密码字段的字节数组（十六进制）方便对比编码
                byte[] pwdBytes = pwd.getBytes("ISO-8859-1"); // 或者用默认编码，试着换着用
                System.out.print("密码字段字节(hex): ");
                for (byte b : pwdBytes) {
                    System.out.printf("%02X ", b);
                }
                System.out.println("\n----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

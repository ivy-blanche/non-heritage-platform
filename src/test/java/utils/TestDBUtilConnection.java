package utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

public class TestDBUtilConnection {

    @Test
    public void testDBUtilConnection() {
        try (Connection conn = DBUtil.getConnection()) {
            assertNotNull(conn, "数据库连接对象不能为 null");

            String sql = "SELECT 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            assertTrue(rs.next(), "结果集应该不为空");
            assertEquals(1, rs.getInt(1), "查询结果应为 1");

        } catch (Exception e) {
            fail("数据库连接异常：" + e.getMessage());
        }
    }
}

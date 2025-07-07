
import org.junit.jupiter.api.Test;
import utils.DBUtil;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class DBUtilTest {

    @Test
    public void testGetConnection() {
        try (Connection conn = DBUtil.getConnection()) {
            assertNotNull(conn, "连接对象不应该为null");
            assertFalse(conn.isClosed(), "连接不应该是关闭状态");
            System.out.println("数据库连接成功！");
        } catch (Exception e) {
            fail("数据库连接失败: " + e.getMessage());
        }
    }
}
package dao.impl.user;

import dao.user.UserHeritageDao;
import model.Heritage;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserHeritageDaoImpl implements UserHeritageDao {

    @Override
    public List<Heritage> findAll() {
        List<Heritage> list = new ArrayList<>();
        String sql = "SELECT id, name, category FROM heritage";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Heritage h = new Heritage();
                h.setId(rs.getString("id"));
                h.setName(rs.getString("name"));
                h.setCategory(rs.getString("category"));
                list.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

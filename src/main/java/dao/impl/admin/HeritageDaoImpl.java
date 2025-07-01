package dao.impl.admin;

import dao.admin.HeritageDao;
import model.Heritage;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeritageDaoImpl implements HeritageDao {
    @Override
    public List<Heritage> findAll() {
        List<Heritage> list = new ArrayList<>();
        String sql = "SELECT id, name, category, description FROM heritage";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Heritage h = new Heritage();
                h.setId(rs.getString("id"));
                h.setName(rs.getString("name"));
                h.setCategory(rs.getString("category"));
                h.setDescription(rs.getString("description"));
                list.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

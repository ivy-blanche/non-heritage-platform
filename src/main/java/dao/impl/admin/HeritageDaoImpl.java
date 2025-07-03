// HeritageDaoImpl实现
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

    @Override
    public Heritage findById(String id) {
        String sql = "SELECT id, name, category, description FROM heritage WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Heritage h = new Heritage();
                    h.setId(rs.getString("id"));
                    h.setName(rs.getString("name"));
                    h.setCategory(rs.getString("category"));
                    h.setDescription(rs.getString("description"));
                    return h;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Heritage heritage) {
        String sql = "INSERT INTO heritage (id, name, category, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, heritage.getId());
            ps.setString(2, heritage.getName());
            ps.setString(3, heritage.getCategory());
            ps.setString(4, heritage.getDescription());
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Heritage heritage) {
        String sql = "UPDATE heritage SET name = ?, category = ?, description = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, heritage.getName());
            ps.setString(2, heritage.getCategory());
            ps.setString(3, heritage.getDescription());
            ps.setString(4, heritage.getId());
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM heritage WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existsById(String id) {
        String sql = "SELECT COUNT(*) FROM heritage WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

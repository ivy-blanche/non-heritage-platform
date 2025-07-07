package dao.impl.admin;

import dao.admin.AdminInheritorDao;
import model.Inheritor;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminInheritorDaoImpl implements AdminInheritorDao {

    @Override
    public List<Inheritor> findAll() {
        List<Inheritor> list = new ArrayList<>();
        String sql = "SELECT id, name, gender, ethnicity, category, project_name, project_id, bio FROM inheritor";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Inheritor i = new Inheritor();
                i.setId(rs.getString("id"));
                i.setName(rs.getString("name"));
                i.setGender(rs.getString("gender"));
                i.setEthnicity(rs.getString("ethnicity"));
                i.setCategory(rs.getString("category"));
                i.setProjectName(rs.getString("project_name"));
                i.setProjectId(rs.getString("project_id"));
                i.setBio(rs.getString("bio"));
                list.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Inheritor findById(String id) {
        String sql = "SELECT id, name, gender, ethnicity, category, project_name, project_id, bio FROM inheritor WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Inheritor i = new Inheritor();
                    i.setId(rs.getString("id"));
                    i.setName(rs.getString("name"));
                    i.setGender(rs.getString("gender"));
                    i.setEthnicity(rs.getString("ethnicity"));
                    i.setCategory(rs.getString("category"));
                    i.setProjectName(rs.getString("project_name"));
                    i.setProjectId(rs.getString("project_id"));
                    i.setBio(rs.getString("bio"));
                    return i;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Inheritor inheritor) {
        String sql = "INSERT INTO inheritor (id, name, gender, ethnicity, category, project_name, project_id, bio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, inheritor.getId());
            ps.setString(2, inheritor.getName());
            ps.setString(3, inheritor.getGender());
            ps.setString(4, inheritor.getEthnicity());
            ps.setString(5, inheritor.getCategory());
            ps.setString(6, inheritor.getProjectName());
            ps.setString(7, inheritor.getProjectId());
            ps.setString(8, inheritor.getBio());
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Inheritor inheritor) {
        String sql = "UPDATE inheritor SET name = ?, gender = ?, ethnicity = ?, category = ?, project_name = ?, project_id = ?, bio = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, inheritor.getName());
            ps.setString(2, inheritor.getGender());
            ps.setString(3, inheritor.getEthnicity());
            ps.setString(4, inheritor.getCategory());
            ps.setString(5, inheritor.getProjectName());
            ps.setString(6, inheritor.getProjectId());
            ps.setString(7, inheritor.getBio());
            ps.setString(8, inheritor.getId());
            int affected = ps.executeUpdate();
            return affected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM inheritor WHERE id = ?";
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
        String sql = "SELECT COUNT(*) FROM inheritor WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

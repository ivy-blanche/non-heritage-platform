package dao.impl.user;

import dao.user.UserInheritorDao;
import model.Inheritor;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInheritorDaoImpl implements UserInheritorDao {

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
}

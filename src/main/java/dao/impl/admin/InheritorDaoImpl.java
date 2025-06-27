package dao.impl.admin;

import dao.admin.InheritorDao;
import model.Inheritor;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InheritorDaoImpl implements InheritorDao {
    @Override
    public List<Inheritor> findAll() {
        List<Inheritor> list = new ArrayList<>();
        String sql = "SELECT id, name, ethnicity FROM inheritor ORDER BY id ASC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Inheritor i = new Inheritor();
                i.setId(rs.getString("id"));
                i.setName(rs.getString("name"));
                i.setEthnicity(rs.getString("ethnicity"));
                list.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

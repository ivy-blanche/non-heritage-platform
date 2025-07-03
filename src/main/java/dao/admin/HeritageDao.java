package dao.admin;

import model.Heritage;

import java.util.List;

public interface HeritageDao {
    List<Heritage> findAll();

    Heritage findById(String id);

    boolean add(Heritage heritage);

    boolean existsById(String id);


    boolean update(Heritage heritage);

    boolean deleteById(String id); // ✅ 新增的方法
}

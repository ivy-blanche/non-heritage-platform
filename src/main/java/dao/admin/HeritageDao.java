// HeritageDao接口
package dao.admin;

import model.Heritage;

import java.util.List;

public interface HeritageDao {
    List<Heritage> findAll();

    Heritage findById(String id);

    boolean add(Heritage heritage);

    boolean update(Heritage heritage);
}

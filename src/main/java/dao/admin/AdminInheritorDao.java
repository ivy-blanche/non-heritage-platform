package dao.admin;

import model.Inheritor;

import java.util.List;

public interface AdminInheritorDao {
    List<Inheritor> findAll();

    Inheritor findById(String id);

    boolean add(Inheritor inheritor);

    boolean update(Inheritor inheritor);

    boolean deleteById(String id);

    boolean existsById(String id);
}

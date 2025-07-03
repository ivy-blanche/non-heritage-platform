package service.admin;

import dao.admin.InheritorDao;
import dao.impl.admin.InheritorDaoImpl;
import model.Inheritor;

import java.util.List;

public class InheritorService {

    private final InheritorDao inheritorDao = new InheritorDaoImpl();

    public List<Inheritor> getAllInheritors() {
        return inheritorDao.findAll();
    }

    public Inheritor getInheritorById(String id) {
        return inheritorDao.findById(id);
    }

    public boolean addInheritor(Inheritor inheritor) {
        if (inheritorDao.existsById(inheritor.getId())) {
            return false;
        }
        return inheritorDao.add(inheritor);
    }

    public boolean updateInheritor(Inheritor inheritor) {
        return inheritorDao.update(inheritor);
    }

    public boolean deleteInheritorById(String id) {
        return inheritorDao.deleteById(id);
    }
}

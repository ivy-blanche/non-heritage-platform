package service;

import dao.InheritorDao;
import dao.impl.InheritorDaoImpl;
import model.Inheritor;
import java.util.List;

public class InheritorService {
    private InheritorDao inheritorDao = new InheritorDaoImpl();

    public List<Inheritor> getAllInheritors() {
        return inheritorDao.findAll();
    }
}
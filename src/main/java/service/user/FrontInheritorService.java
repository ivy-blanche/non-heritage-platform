package service.user;

import dao.user.UserInheritorDao;
import dao.impl.user.UserInheritorDaoImpl;
import model.Inheritor;

import java.util.List;

public class FrontInheritorService {

    private final UserInheritorDao inheritorDao = new UserInheritorDaoImpl();

    public List<Inheritor> getAllInheritors() {
        return inheritorDao.findAll();
    }
}

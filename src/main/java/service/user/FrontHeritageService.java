package service.user;

import dao.admin.HeritageDao;
import dao.impl.admin.HeritageDaoImpl;
import model.Heritage;

import java.util.List;

public class FrontHeritageService {
    private final HeritageDao heritageDao = new HeritageDaoImpl();
    public List<Heritage> getAllHeritages() {
        return heritageDao.findAll();
    }
}

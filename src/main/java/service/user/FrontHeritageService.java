package service.user;

import dao.user.UserHeritageDao;
import dao.impl.user.UserHeritageDaoImpl;
import model.Heritage;

import java.util.List;

public class FrontHeritageService {

    private final UserHeritageDao heritageDao = new UserHeritageDaoImpl();

    public List<Heritage> getAllHeritages() {
        return heritageDao.findAll();
    }
}

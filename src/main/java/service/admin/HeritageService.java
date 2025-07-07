package service.admin;

import dao.admin.AdminHeritageDao;
import dao.impl.admin.AdminHeritageDaoImpl;
import model.Heritage;

import java.util.List;

public class HeritageService {
    private final AdminHeritageDao heritageDao = new AdminHeritageDaoImpl();

    // 获取所有非遗项目
    public List<Heritage> getAllHeritages() {
        return heritageDao.findAll();
    }

}

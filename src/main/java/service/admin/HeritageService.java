package service.admin;

import dao.admin.HeritageDao;
import dao.impl.admin.HeritageDaoImpl;
import model.Heritage;

import java.util.List;

public class HeritageService {
    private final HeritageDao heritageDao = new HeritageDaoImpl();

    // 获取所有非遗项目
    public List<Heritage> getAllHeritages() {
        return heritageDao.findAll();
    }
    
}

package team06.service.impl;

import team06.dao.IApplicationDao;
import team06.dao.impl.ApplicationDaoImpl;
import team06.domain.Application;
import team06.service.IApplicationService;
import java.util.List;

public class ApplicationServiceImpl implements IApplicationService {
    private IApplicationDao appDao = new ApplicationDaoImpl();

    @Override
    public List<Application> queryAllApps() {
        return appDao.queryAllApps();
    }

    @Override
    public List<Application> queryAppById(String userid) { return appDao.queryAppById(userid); }
}

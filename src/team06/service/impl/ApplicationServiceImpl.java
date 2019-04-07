package team06.service.impl;

import team06.dao.IApplicationDao;
import team06.dao.impl.ApplicationDaoImpl;
import team06.domain.Application;
import team06.service.IApplicationService;
import java.util.List;

public class ApplicationServiceImpl implements IApplicationService {
    private IApplicationDao appDao = new ApplicationDaoImpl();

    @Override
    public List<Application> getAllApps() {
        return appDao.queryAllApps();
    }

    @Override
    public Application getAppByAppId(String appid) {
        return appDao.queryAppByAppId(appid);
    }

    @Override
    public boolean checkAppUser(String userid, String appid) {
        Application application = appDao.queryAppByAppId(appid);
        return userid.equals(application.getOwnerid());
    }

    @Override
    public void deleteAppByAppId(String appid) {
        appDao.deleteAppById(appid);
    }

    @Override
    public List<Application> getAppByUserId(String userid) { return appDao.queryAppByUserId(userid); }

    @Override
    public String getWarById(String appid) {
        return appDao.queryWarById(appid);
    }

    @Override
    public void setContextById(String appid, String context) {
        appDao.updateContextById(appid, context);
    }

    @Override
    public String getContextById(String appid) {
        return appDao.queryContextById(appid);
    }

    @Override
    public void setStatusById(String appid, int status) {
        appDao.updateStatusById(appid, status);
    }
}

package team06.platform.service.impl;

import team06.platform.dao.IApplicationDao;
import team06.platform.dao.impl.ApplicationDaoImpl;
import team06.platform.domain.Application;
import team06.platform.service.IApplicationService;
import java.util.List;

public class ApplicationServiceImpl implements IApplicationService {
    private IApplicationDao appDao = new ApplicationDaoImpl();

    @Override
    public List<Application> getAllApps() {
        return appDao.queryAllApps();
    }

    @Override
    public List<Application> getAllLiveAppInfo() { return appDao.queryAllLiveApps(); }

    @Override
    public Application getAppByAppId(String appId) {
        return appDao.queryAppByAppId(appId);
    }

    @Override
    public void increaseVisitByContext(String appContext) {
        appDao.updateVisitByContext(appContext, this.getVisitByContext(appContext) + 1);
    }

    @Override
    public Integer getVisit(String appId) {
        return appDao.queryVisit(appId);
    }

    @Override
    public Integer getVisitByContext(String appContext) {
        return appDao.queryVisitByContext(appContext);
    }

    @Override
    public boolean checkAppUser(String userId, String appId) {
        Application application = appDao.queryAppByAppId(appId);
        return userId.equals(application.getOwnerId());
    }

    @Override
    public void deleteAppByAppId(String appId) {
        appDao.deleteAppById(appId);
    }

    @Override
    public List<Application> getAppByUserId(String userId) { return appDao.queryAppByUserId(userId); }

    @Override
    public String getWarById(String appId) {
        return appDao.queryWarById(appId);
    }

    @Override
    public void setContextById(String appId, String context) {
        appDao.updateContextById(appId, context);
    }

    @Override
    public String getContextById(String appId) {
        return appDao.queryContextById(appId);
    }

    @Override
    public void setStatusById(String appId, int status) {
        appDao.updateStatusById(appId, status);
    }
}

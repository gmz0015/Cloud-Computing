package team06.platform.service.impl;

import team06.platform.dao.IApplicationDao;
import team06.platform.dao.impl.ApplicationDaoImpl;
import team06.platform.domain.Application;
import team06.platform.service.IApplicationService;

import java.io.File;
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
    public Application getAppByContext(String context) {
        return appDao.queryAppByContext(context);
    }

    @Override
    public Application getAppByUUID(String appUUID) {

        return appDao.queryAppByUUID(appUUID);
    }

    @Override
    public void increaseVisitByContext(String appContext) {
        System.out.println("appContext is:" + appContext);
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
        if (userId == null || appId == null) {
            return false;
        }else {
            Application application = appDao.queryAppByAppId(appId);
            return userId.equals(application.getOwnerId());
        }
    }

    @Override
    public String deleteAppByAppId(String appId) {
        String fileName = appDao.queryWarById(appId);
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                appDao.deleteAppById(appId);
                return "Delete File Success";
            } else {
                return "Delete File Failed";
            }
        } else {
            return "Delete File Failed";
        }
//        appDao.deleteAppById(appId);
//        return "Delete File Success";

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

    @Override
    public void setAppUUID(String appID, String appUUID) {
        appDao.updateAppUUID(appID, appUUID);
    }

    @Override
    public String getAppUUID(String appId) {
        return appDao.queryAppUUID(appId);
    }

    @Override
    public Boolean changeName(String appId, String appName) {
        return appDao.updateAppNameById(appId, appName);
    }

    @Override
    public Boolean changeDescription(String appId, String appDescription) {
        return appDao.updateAppDescriptionById(appId, appDescription);
    }

    @Override
    public Boolean changeIcon(String appId, String icon) {
        return appDao.updateAppIconById(appId, icon);
    }
}

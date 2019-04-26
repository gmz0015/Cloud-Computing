package team06.platform.service;

import team06.platform.domain.Application;

import java.util.List;

public interface IApplicationService {

    /**
     * get all applications
     * @return all applications' info
     */
    List<Application> getAllApps();

    List<Application> getAllLiveAppInfo();

    List<Application> getAppByUserId(String userId);

    Application getAppByAppId(String appId);

    void increaseVisitByContext(String appContext);

    Integer getVisit(String appId);

    Integer getVisitByContext(String appContext);

    boolean checkAppUser(String userId, String appId);

    void deleteAppByAppId(String appId);

    /* PATH */
    String getWarById(String appId);

    void setContextById(String appId, String context);

    String getContextById(String appId);

    void setStatusById(String appId, int status);
}

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

    Integer getChargeByAppId(String appId);

    Application getAppByContext(String context);

    Application getAppByUUID(String appUUID);

    void increaseVisitByContext(String appContext);

    Integer getVisit(String appId);

    Integer getVisitByContext(String appContext);

    boolean checkAppUser(String userId, String appId);

    String deleteAppByAppId(String appId);

    /* PATH */
    String getWarById(String appId);

    void setContextById(String appId, String context);

    String getContextById(String appId);

    void setStatusById(String appId, int status);

    void setAppUUID(String appID, String appUUID);

    void setChargeByAppId(String appId, Integer chargeMode);

    void setRatingByAppId(String appId, Integer rating);

    String getAppUUID(String appId);

    Boolean changeName(String appId, String appName);

    Boolean changeDescription(String appId, String appDescription);

    Boolean changeIcon(String appId, String icon);
}

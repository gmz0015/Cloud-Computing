package team06.platform.dao;

import team06.platform.domain.Application;

import java.util.List;

public interface IApplicationDao {

    /**
     * get all applications
     * @return all applications' info
     */
    List<Application> queryAllApps();

    /**
     * get all running applications
     */
    List<Application> queryAllLiveApps();

    /**
     * get the user's all applications
     * @return all applications' info
     */
    List<Application> queryAppByUserId(String userid);

    /**
     * get the application by appId
     * @param appId
     * @return
     */
    Application queryAppByAppId(String appId);

    /**
     * get the application's charge mode by appId
     * @param appId
     * @return
     */
    Integer queryChargeByAppId(String appId);

    Application queryAppByUUID(String appUUID);

    /* PATH */
    /**
     * query the path of war file by appId
     * @param appId
     * @return
     */
    String queryWarById(String appId);

    /**
     * query the visits of an application by its id
     * @param appId
     * @return
     */
    Integer queryVisit(String appId);

    /**
     * query the rating of an application by its id
     * @param appId
     * @return
     */
    Double queryRating(String appId);

    /**
     * query the visits of an application by its context path
     * @param appContext
     * @return
     */
    Integer queryVisitByContext(String appContext);

    /**
     * drop the application
     * @param appId
     */
    void deleteAppById(String appId);

    /**
     * update the context path of an application
     * @param appId
     */
    void updateContextById(String appId, String contextPath);

    /**
     * update the war file path by app id
     * @param appId
     * @param warPath
     */
    void updateWarById(String appId, String warPath);

    /**
     * update the application's charge mode by appId
     * @param appId
     */
    void updateChargeByAppId(String appId, Integer chargeMode);

    /**
     * query the context path by appId
     * @param appId
     * @return
     */
    String queryContextById(String appId);

    /**
     * query the app info by its context path
     * @param context
     * @return
     */
    Application queryAppByContext(String context);

    String queryAppUUID(String appId);

    /**
     * update the status of an application
     * @param appId
     * @param status
     */
    void updateStatusById(String appId, int status);

    /**
     * update the visit number of an application by its context path
     * @param appContext
     */
    void updateVisitByContext(String appContext, Integer newVisits);

    void updateVisitById(String appId, Integer newVisits);

    Boolean updateAppNameById(String appId, String name);

    Boolean updateAppDescriptionById(String appId, String description);

    Boolean updateAppIconById(String appId, String icon);

    Boolean updateAppUUID(String appId, String appUUID);

    void updateRating(String appId, Double rating);
}

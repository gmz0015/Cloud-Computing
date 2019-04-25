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
     * get the application by appid
     * @param appid
     * @return
     */
    Application queryAppByAppId(String appid);

    /* PATH */
    /**
     * query the path of war file by appid
     * @param appid
     * @return
     */
    String queryWarById(String appid);

    /**
     * drop the application
     * @param appid
     */
    void deleteAppById(String appid);

    /**
     * update the context path of an application
     * @param appid
     */
    void updateContextById(String appid, String contextPath);

    /**
     * query the context path by appid
     * @param appid
     * @return
     */
    String queryContextById(String appid);

    /**
     * update the status of an application
     * @param appid
     * @param status
     */
    void updateStatusById(String appid, int status);
}

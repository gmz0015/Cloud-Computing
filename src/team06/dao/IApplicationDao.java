package team06.dao;

import team06.domain.Application;

import java.util.List;

public interface IApplicationDao {

    /**
     * get all applications
     * @return all applications' info
     */
    List<Application> queryAllApps();

    /**
     * get all applications
     * @return all applications' info
     */
    List<Application> queryAppById(String userid);

    /**
     * query the path of war file by appid
     * @param appid
     * @return
     */
    String queryWarById(String appid);

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

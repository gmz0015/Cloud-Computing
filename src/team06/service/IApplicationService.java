package team06.service;

import team06.domain.Application;

import java.util.List;

public interface IApplicationService {

    /**
     * get all applications
     * @return all applications' info
     */
    List<Application> queryAllApps();

    List<Application> queryAppById(String userid);

    String getWarById(String appid);

    void setContextById(String appid, String context);

    String getContextById(String appid);

    void setStatusById(String appid, int status);
}

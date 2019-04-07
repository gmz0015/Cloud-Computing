package team06.service;

import team06.domain.Application;

import java.util.List;

public interface IApplicationService {

    /**
     * get all applications
     * @return all applications' info
     */
    List<Application> getAllApps();

    List<Application> getAppByUserId(String userid);

    Application getAppByAppId(String appid);

    boolean checkAppUser(String userid, String appid);

    void deleteAppByAppId(String appid);

    /* PATH */
    String getWarById(String appid);

    void setContextById(String appid, String context);

    String getContextById(String appid);

    void setStatusById(String appid, int status);
}

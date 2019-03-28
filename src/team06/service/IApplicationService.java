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
}

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
}

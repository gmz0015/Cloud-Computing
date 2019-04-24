package team06.platform.dao;

import team06.platform.domain.Application;
import team06.platform.domain.DBUser;

import java.util.List;

public interface IAdminDao {

    /**
     * Query all databases
     * @return
     */
    List<String> queryAllDBs();

    /**
     * Query all Applications
     * @return
     */
    List<Application> queryAllApps();

    /**
     * Get all Users' info within database
     * @return
     */
    List<DBUser> queryAllUsers();
}

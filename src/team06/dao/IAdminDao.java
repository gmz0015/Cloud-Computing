package team06.dao;

import team06.domain.Application;
import team06.domain.DBUser;
import team06.domain.Database;

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

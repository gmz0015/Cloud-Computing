package team06.platform.dao;

import team06.platform.domain.Application;

import java.sql.SQLException;

/**
 * Store the war file path of an application
 */
public interface IManagerDao {

    /**
     * Insert the war file path to database
     * @param warPath
     */
    void insertWarPath(String appId, String warPath);

    /**
     * Insert the context path
     * @param ContextPath
     */
    void insertContextPath(String ContextPath);

    void insertNewApp(Application application, String appUUID) throws SQLException;
}

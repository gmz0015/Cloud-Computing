package team06.platform.dao;

import team06.platform.domain.Database;

import java.util.List;
import java.util.Map;

public interface IDatabaseDao {

    Database createDBbyId(String userid);

    /**
     * execute the SQL provided by user
     * @param SQL
     * @return
     */
    String executeSQL(String SQL);

    String changePassword(String username, String newPassword);

    /**
     * Query the usage of a database based on its name
     * @param databaseName
     * @return
     */
    String queryDBUsage(String databaseName);

    /**
     * Query the usage of each table within a database
     * @param databaseName
     * @return
     */
    List<Map<String, String>> queryDBTableUsage(String databaseName);

    /**
     * Query the database info by userid
     * @param userid
     * @return
     */
    Database queryDBbyid(String userid);

    /**
     * Query the database info by database name
     * @param name
     * @return
     */
    Database queryDBbyName(String name);

    /**
     * Query all database info
     * @return
     */
    List<Database> queryAllDBs();
}

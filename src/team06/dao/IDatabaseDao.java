package team06.dao;

import team06.domain.Database;

import java.util.List;

public interface IDatabaseDao {

    int createDBbyId(String userid);

    /**
     * Query the database info by userid
     * @param userid
     * @return
     */
    Database queryDBbyid(String userid);

    /**
     * Query all database info
     * @return
     */
    List<Database> queryAllDBs();
}

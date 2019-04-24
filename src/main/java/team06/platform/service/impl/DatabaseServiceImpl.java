package team06.platform.service.impl;

import team06.platform.dao.IDatabaseDao;
import team06.platform.dao.impl.DatabaseDaoImpl;
import team06.platform.domain.Database;
import team06.platform.service.IDatabaseService;

import java.util.List;

public class DatabaseServiceImpl implements IDatabaseService {
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();

    @Override
    public Database createDBbyId(String userid) {
        return databaseDao.createDBbyId(userid);
    }

    @Override
    public Database queryDBbyid(String userid) {
        Database database = databaseDao.queryDBbyid(userid);
        if (database.getDbid().equals("none")) {
            //need to create database and user
            return databaseDao.createDBbyId(userid);
        }else {
            return database;
        }
    }

    @Override
    public List<Database> queryAllDBs() {
        return null;
    }

    @Override
    public String changePassword(String username, String newPassword) {
        return databaseDao.changePassword(username, newPassword);
    }

    @Override
    public String executeSQL(String SQL) {
        return databaseDao.executeSQL(SQL);
    }
}

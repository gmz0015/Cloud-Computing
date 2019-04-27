package team06.platform.service.impl;

import team06.platform.dao.IDatabaseDao;
import team06.platform.dao.impl.DatabaseDaoImpl;
import team06.platform.domain.Database;
import team06.platform.service.IDatabaseService;

import java.util.List;

public class DatabaseServiceImpl implements IDatabaseService {
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();

    @Override
    public Database createDBbyId(String userId, String userName) {
        return databaseDao.createDBbyId(userId, userName);
    }

    @Override
    public Database queryDBbyid(String userId, String userName) {
        Database database = databaseDao.queryDBbyid(userId);
        if (database.getDbId().equals("none")) {
            //need to create database and user
            return databaseDao.createDBbyId(userId, userName);
        }else {
            return database;
        }
    }

    @Override
    public List<Database> queryAllDBs() {
        return null;
    }

    @Override
    public String getUsage(String databaseName) {
        return databaseDao.queryDBUsage(databaseName);
    }

    @Override
    public String changePassword(String userName, String newPassword) {
        return databaseDao.changePassword(userName, newPassword);
    }

    @Override
    public String executeSQL(String SQL) {
        return databaseDao.executeSQL(SQL);
    }
}

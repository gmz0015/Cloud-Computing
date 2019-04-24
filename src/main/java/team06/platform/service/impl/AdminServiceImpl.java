package team06.platform.service.impl;

import team06.platform.dao.IAdminDao;
import team06.platform.dao.IDatabaseDao;
import team06.platform.dao.impl.AdminDaoImpl;
import team06.platform.dao.impl.DatabaseDaoImpl;
import team06.platform.domain.Application;
import team06.platform.domain.DBUser;
import team06.platform.domain.Database;
import team06.platform.service.IAdminService;

import java.util.LinkedList;
import java.util.List;

public class AdminServiceImpl implements IAdminService {
    private IAdminDao adminDao = new AdminDaoImpl();
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();

    @Override
    public List<Database> queryAllDBs() {
        List<String> databasesName = adminDao.queryAllDBs();
        List<Database> databases = new LinkedList<>();
        for (String databaseName: databasesName) {
            databases.add(databaseDao.queryDBbyName(databaseName));
        }
        return databases;
    }

    @Override
    public List<Application> queryAllApps() {
        return null;
    }

    @Override
    public List<DBUser> queryAllUsers() {
        return adminDao.queryAllUsers();
    }
}

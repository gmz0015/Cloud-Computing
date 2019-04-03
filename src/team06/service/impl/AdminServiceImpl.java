package team06.service.impl;

import team06.dao.IAdminDao;
import team06.dao.impl.AdminDaoImpl;
import team06.domain.Application;
import team06.domain.DBUser;
import team06.domain.Database;
import team06.service.IAdminService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    private IAdminDao adminDao = new AdminDaoImpl();

    @Override
    public List<Database> queryAllDBs() {
        return adminDao.queryAllDBs();
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

package team06.service.impl;

import team06.dao.IManagerDao;
import team06.dao.impl.ManagerDaoImpl;
import team06.domain.Application;
import team06.service.IManagerService;

import java.sql.SQLException;

public class ManagerService implements IManagerService {
    private IManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public int insertNewApp(Application application) throws SQLException {
        managerDao.insertNewApp(application);
        return 0;
    }
}

package team06.platform.service.impl;

import team06.platform.dao.IManagerDao;
import team06.platform.dao.impl.ManagerDaoImpl;
import team06.platform.domain.Application;
import team06.platform.service.IManagerService;

import java.sql.SQLException;

public class ManagerService implements IManagerService {
    private IManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public int insertNewApp(Application application) throws SQLException {
        managerDao.insertNewApp(application);
        return 0;
    }
}

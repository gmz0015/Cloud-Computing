package team06.service.impl;

import team06.dao.IDatabaseDao;
import team06.dao.impl.DatabaseDaoImpl;
import team06.domain.Database;
import team06.service.IDatabaseService;

import java.util.List;

public class DatabaseServiceImpl implements IDatabaseService {
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();

    @Override
    public Database queryDBbyid(int userid) {
        return databaseDao.queryDBbyid(userid);
    }

    @Override
    public List<Database> queryAllDBs() {
        return null;
    }
}

package team06.platform.web.bean;

import team06.platform.dao.IDatabaseDao;
import team06.platform.dao.impl.DatabaseDaoImpl;

import java.util.List;
import java.util.Map;

public class DatabaseBean {
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();


    public void queryDBbyid() {
        databaseDao.queryDBbyid("1");
    }

    public String queryUsage(String databaseName) {
        return databaseDao.queryDBUsage(databaseName);
    }

    public List<Map<String, String>> queryTableUsage(String databaseName) {
        return databaseDao.queryDBTableUsage(databaseName);
    }
}

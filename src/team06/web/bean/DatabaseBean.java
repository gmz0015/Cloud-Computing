package team06.web.bean;

import team06.dao.IDatabaseDao;
import team06.dao.impl.DatabaseDaoImpl;

public class DatabaseBean {
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();


    public void queryDBbyid() {
        databaseDao.queryDBbyid(1);
    }
}

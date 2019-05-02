package team06.platform.dao.impl;

import team06.platform.dao.IManagerDao;
import team06.platform.domain.Application;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDaoImpl implements IManagerDao {
    @Override
    public void insertWarPath(String appId, String warPath) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "UPDATE CloudComputing.applications SET warPath='" + warPath + "' WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();

        }catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public void insertContextPath(String ContextPath) {

    }

    @Override
    public void insertNewApp(Application application, String appUUID) throws SQLException {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "INSERT INTO CloudComputing.applications VALUES ( '" +
                    application.getAppId() + "', '" +
                    application.getName() + "', '" +
                    application.getDescription() + "', '" +
                    application.getOwnerId() + "', '" +
                    application.getOwnerName() + "'," +
                    application.getVisits() + "," +
                    application.getRating() + "," +
                    application.getStatus() + ", '" +
                    application.getDbId() + "', '" +
                    application.getWarPath() + "', '" +
                    application.getContextPath() + "', '" +
                    application.getIconPath() + "', '" +
                    appUUID + "', " +
                    0 +
                    ");";
            System.out.println("insert sql" + sql);
            System.out.println("sql is: " + sql);
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();

        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}

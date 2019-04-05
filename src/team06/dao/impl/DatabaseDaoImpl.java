package team06.dao.impl;

import team06.dao.IDatabaseDao;
import team06.domain.Application;
import team06.domain.Database;
import team06.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DatabaseDaoImpl implements IDatabaseDao {
    private String dbid = "1";
    private String dbname = "testdb";
    private String dbusername = "testusername";
    private String dbpassword = "123456";

    @Override
    public int createDBbyId(String userid) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction


            // Need to create database
            st = null;
            rs = null;
            String sql1 = "CREATE USER '" + dbusername + "'@'localhost' identified BY '" + dbpassword + "';";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            String sql2 = "CREATE database " + dbname + " DEFAULT CHARSET utf8 COLLATE utf8_general_ci;";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            String sql3 = "GRANT ALL on " + dbname + ".* TO '" + dbusername + "'@'localhost';";
            st = conn.prepareStatement(sql3);
            st.executeUpdate();
            String sql4 = "UPDATE CloudComputing.database SET dbid=" + dbid + " WHERE userid=" + userid;
            st = conn.prepareStatement(sql4);
            st.executeUpdate();
            conn.commit(); // Commit transaction after above sql update successful
        }catch (Exception e) {
            System.out.println("[team06.dao.impl.DatabaseDaoImpl.createDBbyId]: " + e);
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return 1;
    }

    @Override
    public Database queryDBbyid(String userid) {
        Database database = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.database WHERE userid=" + userid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while (rs.next()) {
                database = new Database(rs.getString("userid"), rs.getString("dbid"),
                        rs.getString("dbname"), rs.getString("dbusername"), rs.getString("dbpassword"));
            }
        }catch (Exception e) {
            System.out.println("[team06.dao.impl.DatabaseDaoImpl.queryDBbyid]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return database;
    }

    @Override
    public List<Database> queryAllDBs() {
        return null;
    }

    private String generateID() { return String.valueOf(System.currentTimeMillis()); }
}

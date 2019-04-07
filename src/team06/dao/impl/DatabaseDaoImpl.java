package team06.dao.impl;

import team06.dao.IDatabaseDao;
import team06.domain.Database;
import team06.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DatabaseDaoImpl implements IDatabaseDao {

    @Override
    public Database createDBbyId(String userid) {
        String dbid = userid + generateID().substring(1,3);
        String DBNAME = dbid;
        String DBUSERNAME = dbid;
        String DBPASSWORD = "123456";

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
            String sql1 = "CREATE USER '" + DBUSERNAME + "'@'localhost' identified BY '" + DBPASSWORD + "';";
            st = conn.prepareStatement(sql1);
            st.execute();
            String sql2 = "CREATE database " + DBNAME + " DEFAULT CHARSET utf8 COLLATE utf8_general_ci;";
            st = conn.prepareStatement(sql2);
            st.execute();
            String sql3 = "GRANT ALL on " + DBNAME + ".* TO '" + DBUSERNAME + "'@'localhost';";
            st = conn.prepareStatement(sql3);
            st.execute();
            String sql4 = "UPDATE CloudComputing.database SET dbid='" + dbid + "',dbname='" + DBNAME + "',dbusername='" + DBUSERNAME + "',dbpassword='" + DBPASSWORD + "' WHERE userid=" + userid;
            st = conn.prepareStatement(sql4);
            st.executeUpdate();
            conn.commit(); // Commit transaction after above sql update successful
        }catch (Exception e) {
            System.out.println("[team06.dao.impl.DatabaseDaoImpl.createDBbyId]: " + e);
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return new Database(userid, dbid, DBNAME, DBUSERNAME, DBPASSWORD);
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
    public Database queryDBbyName(String name) {
        Database database = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.database WHERE dbname='" + name + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            if (rs.next()) {
                database = new Database(rs.getString("userid"), rs.getString("dbid"),
                        name, rs.getString("dbusername"), rs.getString("dbpassword"));
            }else {
                database = new Database("[Not Applicable]", "[Not Applicable]",
                        name, "[Not Applicable]", "[Not Applicable]");
            }
        }catch (Exception e) {
            System.out.println("[team06.dao.impl.DatabaseDaoImpl.queryDBbyName]: " + e);
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

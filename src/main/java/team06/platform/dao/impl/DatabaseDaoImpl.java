package team06.platform.dao.impl;

import team06.platform.dao.IDatabaseDao;
import team06.platform.domain.Database;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            String sql3 = "GRANT SELECT ,CREATE ,INSERT ,UPDATE on " + DBNAME + ".* TO '" + DBUSERNAME + "'@'localhost';";
            st = conn.prepareStatement(sql3);
            st.execute();
            String sql4 = "UPDATE CloudComputing.database SET dbid='" + dbid + "',dbname='" + DBNAME + "',dbusername='" + DBUSERNAME + "',dbpassword='" + DBPASSWORD + "' WHERE userid=" + userid;
            st = conn.prepareStatement(sql4);
            st.executeUpdate();
            conn.commit(); // Commit transaction after above sql update successful
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.createDBbyId]: " + e);
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return new Database(userid, dbid, DBNAME, DBUSERNAME, DBPASSWORD);
    }

    @Override
    public String executeSQL(String SQL) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String response = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = SQL + ";";
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();
            response = "Execute Successfully";
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.executeSQL]: " + e);
            response = e.getMessage();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }

        return response;
    }

    @Override
    public String changePassword(String username, String newPassword) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql1="ALTER USER '" + username + "'@'localhost' IDENTIFIED BY '" + newPassword + "';";
            st = conn.prepareStatement(sql1);
            st.execute();
            String sql2 = "UPDATE CloudComputing.database SET dbpassword='" + newPassword + "' WHERE dbusername='" + username + "';";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            String sql3="FLUSH PRIVILEGES;";
            st = conn.prepareStatement(sql3);
            st.execute();
            conn.commit();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.changePassword]: " + e);
            return "Error:" + e.getMessage();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return "Change Password - Successful";
    }

    @Override
    public String queryDBUsage(String databaseName) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String usage = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT concat(round(sum(DATA_LENGTH)/1024+sum(INDEX_LENGTH)/1024),'KB') AS 'usage' FROM information_schema.TABLES WHERE table_schema='" + databaseName + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while (rs.next()) {
                usage = rs.getString("usage");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.queryDBUsage]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return usage;
    }

    @Override
    public List<Map<String, String>> queryDBTableUsage(String databaseName) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String usage = null;
        Map<String, String> tempUsage;
        List<Map<String, String>> tableUsage = new ArrayList<>();

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "select table_name,table_rows,data_length+index_length,concat(round((data_length+index_length)/1024,2),'KB') data from information_schema.TABLES where table_schema='" + "CloudComputing" + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while (rs.next()) {
                tempUsage = new HashMap<>();
                tempUsage.put("name", rs.getString("TABLE_NAME"));
                tempUsage.put("row", rs.getString("TABLE_ROWS"));
                tempUsage.put("byteUsage", rs.getString("data_length+index_length"));
                tempUsage.put("KBUsage", rs.getString("data"));
                tableUsage.add(tempUsage);
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.queryDBTableUsage]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return tableUsage;
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
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.queryDBbyid]: " + e);
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
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.queryDBbyName]: " + e);
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

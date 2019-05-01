package team06.platform.dao.impl;

import team06.platform.dao.IDatabaseDao;
import team06.platform.domain.Database;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DatabaseDaoImpl implements IDatabaseDao {

    @Override
    public Database createDBbyId(String userId, String userName) {
        String dbId = userId + generateID().substring(1,3);
        String DBNAME = userName;
        String DBUSERNAME = userName + generateID();
        String tempPWDs = UUID.randomUUID().toString();
        StringBuilder DBPASSWORD = new StringBuilder();
        for (String tempPWD: tempPWDs.split("-")) {
            DBPASSWORD.append(tempPWD);
        }

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
            String sql1 = "CREATE USER '" + DBUSERNAME + "'@'localhost' identified BY '" + DBPASSWORD.toString() + "';";
            st = conn.prepareStatement(sql1);
            st.execute();
            String sql2 = "CREATE database " + DBNAME + " DEFAULT CHARSET utf8 COLLATE utf8_general_ci;";
            st = conn.prepareStatement(sql2);
            st.execute();
            String sql3 = "GRANT SELECT,INSERT,UPDATE ,DELETE ,CREATE,DROP on " + DBNAME + ".* TO '" + DBUSERNAME + "'@'localhost';";
            st = conn.prepareStatement(sql3);
            st.execute();
            String sql4 = "INSERT INTO CloudComputing.database VALUES (" +
                    "'" + userId + "'," +
                    "'" + dbId + "'," +
                    "'" + DBNAME + "'," +
                    "'" + DBUSERNAME + "'," +
                    "'" + DBPASSWORD + "');";
            st = conn.prepareStatement(sql4);
            st.executeUpdate();
            conn.commit(); // Commit transaction after above sql update successful
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.createDBbyId]: " + e);
            return null;
        }finally {
            JdbcUtils.release(conn, st, rs);
        }
        return new Database(userId, dbId, DBNAME, DBUSERNAME, DBPASSWORD.toString());
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
    public String changePassword(String userName, String newPassword) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql1="ALTER USER '" + userName + "'@'localhost' IDENTIFIED BY '" + newPassword + "';";
            st = conn.prepareStatement(sql1);
            st.execute();
            String sql2 = "UPDATE CloudComputing.database SET dbPassword='" + newPassword + "' WHERE dbUserName='" + userName + "';";
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

            String sql = "select table_name,table_rows,data_length+index_length,concat(round((data_length+index_length)/1024,2),'KB') data from information_schema.TABLES where table_schema='" + databaseName + "';";
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
    public Database queryDBbyid(String userId) {
        Database database = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.database WHERE userId='" + userId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while (rs.next()) {
                database = new Database(rs.getString("userId"), rs.getString("dbId"),
                        rs.getString("dbName"), rs.getString("dbUserName"), rs.getString("dbPassword"));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.queryDBbyid]: " + e);
            database = new Database("none", "",
                    "", "", "");
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

            String sql = "SELECT * FROM CloudComputing.database WHERE dbName='" + name + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            if (rs.next()) {
                database = new Database(rs.getString("userId"), rs.getString("dbId"),
                        name, rs.getString("dbUserName"), rs.getString("dbPassword"));
            }else {
                database = new Database("[Not Applicable]", "[Not Applicable]",
                        name, "[Not Applicable]", "[Not Applicable]");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.DatabaseDaoImpl.queryDBbyName]: " + e);
            database = new Database("", "",
                    "", "", "");
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

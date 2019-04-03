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
    private int dbid = 1;
    private String dbname = "testdb";
    private String dbusername = "testusername";
    private String dbpassword = "123456";

    @Override
    public Database queryDBbyid(int userid) {
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
                if (rs.getInt("dbid") == 0) {

                    // Need to create database
                    st = null;
                    rs = null;
                    String sql1 = "CREATE USER '" + dbusername + "'@'localhost' identified BY '" + dbpassword + "';";
                    st = conn.prepareStatement(sql1);
                    st.executeUpdate();
                    String sql2 = "CREATE database " + dbname + " DEFAULT CHARSET utf8 COLLATE utf8_general_ci;";
                    st = conn.prepareStatement(sql2);
                    st.executeUpdate();
                    String sql3 = "GRANT ALL on " + dbname + ".* to '" + dbusername + "'@'localhost';";
                    st = conn.prepareStatement(sql3);
                    st.executeUpdate();
                    String sql4 = "update CloudComputing.database set dbid=" + dbid + " where userid=" + userid;
                    st = conn.prepareStatement(sql4);
                    st.executeUpdate();
                    conn.commit(); // Commit transaction after above sql update successful
                    database = new Database(userid, dbid, dbname, dbusername, dbpassword);
                } else {
                    database = new Database(rs.getInt("userid"), rs.getInt("dbid"),
                            rs.getString("dbname"), rs.getString("dbusername"), rs.getString("dbpassword"));
                }
            }
        }catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
            return database;
        }
    }

    @Override
    public List<Database> queryAllDBs() {
        return null;
    }
}

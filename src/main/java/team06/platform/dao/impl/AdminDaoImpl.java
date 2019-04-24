package team06.platform.dao.impl;

import team06.platform.dao.IAdminDao;
import team06.platform.domain.Application;
import team06.platform.domain.DBUser;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AdminDaoImpl implements IAdminDao {
    @Override
    public List<String> queryAllDBs() {
        List<String> allDB = new LinkedList<>();

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SHOW databases";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                allDB.add(rs.getString("Database"));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AdminDaoImpl.queryAllDBs] Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return allDB;
    }

    @Override
    public List<Application> queryAllApps() {
        return null;
    }

    @Override
    public List<DBUser> queryAllUsers() {
        List<DBUser> dbUsers = new LinkedList<>();
        String[] temp;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select distinct concat('user: ''',user,'''@''',host,''';') as query from mysql.user;";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                temp = rs.getString("query").split("'");
                dbUsers.add(new DBUser(temp[1], temp[3]));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AdminDaoImpl.queryAllDBs] Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return dbUsers;
    }
}

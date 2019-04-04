package team06.dao.impl;

import javabean.UserBean;
import team06.dao.IApplicationDao;
import team06.domain.Application;
import team06.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDaoImpl implements IApplicationDao {
    @Override
    public List<Application> queryAllApps() {
        List<Application> appsInfo = new ArrayList<Application>();
        UserBean userBean = new UserBean();
        String username;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT appid,appname,ownerid,ownername,visits,rating,status FROM CloudComputing.applications";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                username = userBean.getUserNameById(rs.getInt("ownerid"));
                appsInfo.add(new Application(
                        rs.getString("appid"), rs.getString("appname"), rs.getString("ownerid"),
                        rs.getString("ownername"), rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        "", "", ""));
            }
        }catch (Exception e) {
            System.out.println("(ApplicationDaoImpl.queryAllApps)Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appsInfo;
    }

    @Override
    public List<Application> queryAppById(String userid) {
        List<Application> appInfo = new ArrayList<Application>();

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT appid,appname,visits,rating,status,dbid,contextpath FROM CloudComputing.applications WHERE ownerid=" + userid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appInfo.add(new Application(
                        rs.getString("appid"), rs.getString("appname"), userid,
                        "", rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbid"), "", rs.getString("contextpath")));
            }
        }catch (Exception e) {
            System.out.println("(ApplicationDaoImpl.queryAppById) Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }

        return appInfo;
    }
}

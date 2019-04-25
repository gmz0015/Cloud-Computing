package team06.platform.dao.impl;

import team06.platform.dao.IApplicationDao;
import team06.platform.domain.Application;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDaoImpl implements IApplicationDao {
    @Override
    public List<Application> queryAllApps() {
        List<Application> appsInfo = new ArrayList<Application>();
        String username;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appsInfo.add(new Application(
                        rs.getString("appid"), rs.getString("appname"), rs.getString("description"), rs.getString("ownerid"),
                        rs.getString("ownername"), rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbid"), rs.getString("warpath"), rs.getString("contextpath"), rs.getString("iconPath")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryAllApps]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appsInfo;
    }

    @Override
    public List<Application> queryAllLiveApps() {
        List<Application> appsInfo = new ArrayList<Application>();
        String username;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications WHERE status=2";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appsInfo.add(new Application(
                        rs.getString("appid"), rs.getString("appname"), rs.getString("description"), rs.getString("ownerid"),
                        rs.getString("ownername"), rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbid"), rs.getString("warpath"), rs.getString("contextpath"), rs.getString("iconPath")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryAllApps]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appsInfo;
    }

    @Override
    public Application queryAppByAppId(String appid) {
        Application appInfo = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications WHERE appid=" + appid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appInfo = new Application(
                        appid, rs.getString("appname"), rs.getString("description"), rs.getString("ownerid"),
                        "", rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbid"), rs.getString("warpath"), rs.getString("contextpath"), rs.getString("iconPath"));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.implApplicationDaoImpl.queryAppByAppId]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }

        return appInfo;
    }

    @Override
    public List<Application> queryAppByUserId(String userid) {
        List<Application> appInfo = new ArrayList<Application>();

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications WHERE ownerid=" + userid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appInfo.add(new Application(
                        rs.getString("appid"), rs.getString("appname"), rs.getString("description"), userid,
                        "", rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbid"), rs.getString("warpath"), rs.getString("contextpath"), rs.getString("iconPath")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.implApplicationDaoImpl.queryAppByUserId]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }

        return appInfo;
    }

    @Override
    public String queryWarById(String appid) {
        String warPath = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT warpath FROM CloudComputing.applications WHERE appid=" + appid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                warPath = rs.getString("warpath");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryWarById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return warPath;
    }

    @Override
    public void deleteAppById(String appid) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "DELETE FROM `CloudComputing`.`applications` WHERE (`appid` = '" + appid + "');";
            st = conn.prepareStatement(sql);
            st.execute();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.deleteAppById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public void updateContextById(String appid, String contextPath) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE CloudComputing.applications SET contextpath='" + contextPath + "' WHERE appid='" + appid + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateContextById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public String queryContextById(String appid) {
        String context = "";
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT contextpath FROM CloudComputing.applications WHERE appid='" + appid + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                context = rs.getString("contextpath");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateContextById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return context;
    }

    @Override
    public void updateStatusById(String appid, int status) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE CloudComputing.applications SET status=" + status + " WHERE appid='" + appid + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateStatusById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}

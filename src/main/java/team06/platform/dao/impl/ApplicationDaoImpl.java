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
                        rs.getString("appId"), rs.getString("appName"), rs.getString("description"), rs.getString("ownerId"),
                        rs.getString("ownerName"), rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbId"), rs.getString("warPath"), rs.getString("contextPath"), rs.getString("iconPath")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryAllApps]: " + e);
            appsInfo.add(new Application("", "", "", "", "",
                    0, 0, 0, "", "", "", ""));
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appsInfo;
    }

    @Override
    public List<Application> queryAllLiveApps() {
        List<Application> appsInfo = new ArrayList<Application>();

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
                        rs.getString("appId"), rs.getString("appName"), rs.getString("description"), rs.getString("ownerId"),
                        rs.getString("ownerName"), rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbId"), rs.getString("warPath"), rs.getString("contextPath"), rs.getString("iconPath")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryAllApps]: " + e);
            appsInfo.add(new Application("", "", "", "", "",
                    0, 0, 0, "", "", "", ""));
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appsInfo;
    }

    @Override
    public Application queryAppByAppId(String appId) {
        Application appInfo = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appInfo = new Application(
                        appId, rs.getString("appName"), rs.getString("description"), rs.getString("ownerId"),
                        "", rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbId"), rs.getString("warPath"), rs.getString("contextPath"), rs.getString("iconPath"));
            }

        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryAppByAppId]: " + e);
            appInfo = new Application("", "", "", "", "",
                    0, 0, 0, "", "", "", "");
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appInfo;
    }

    @Override
    public List<Application> queryAppByUserId(String userId) {
        List<Application> appInfo = new ArrayList<Application>();

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications WHERE ownerId='" + userId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appInfo.add(new Application(
                        rs.getString("appId"), rs.getString("appName"), rs.getString("description"), userId,
                        "", rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbId"), rs.getString("warPath"), rs.getString("contextPath"), rs.getString("iconPath")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.implApplicationDaoImpl.queryAppByUserId]: " + e);
            appInfo.add(new Application("", "", "", "", "",
                    0, 0, 0, "", "", "", ""));
        }finally{
            JdbcUtils.release(conn, st, rs);
        }

        return appInfo;
    }

    @Override
    public String queryWarById(String appId) {
        String warPath = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT warpath FROM CloudComputing.applications WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                warPath = rs.getString("warPath");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryWarById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return warPath;
    }

    @Override
    public Integer queryVisit(String appId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Integer visits = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT visits FROM CloudComputing.applications WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                visits = rs.getInt("visits");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryVisit]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return visits;
    }

    @Override
    public Integer queryVisitByContext(String appContext) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Integer visits = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT visits FROM CloudComputing.applications WHERE contextPath='" + appContext + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                visits = rs.getInt("visits");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryVisitByContext]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return visits;
    }

    @Override
    public void deleteAppById(String appId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "DELETE FROM CloudComputing.applications WHERE ('appId' = '" + appId + "');";
            st = conn.prepareStatement(sql);
            st.execute();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.deleteAppById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public void updateContextById(String appId, String contextPath) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE CloudComputing.applications SET contextPath='" + contextPath + "' WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateContextById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public String queryContextById(String appId) {
        String context = "";
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT contextpath FROM CloudComputing.applications WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                context = rs.getString("contextPath");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateContextById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return context;
    }

    @Override
    public Application queryAppByContext(String context) {
        Application appInfo = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.applications WHERE contextPath='" + context + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                appInfo = new Application(
                        rs.getString("appId"), rs.getString("appName"), rs.getString("description"), rs.getString("ownerId"),
                        "", rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status"),
                        rs.getString("dbId"), rs.getString("warPath"), context, rs.getString("iconPath"));
            }

        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.queryAppByContext]: " + e);
            appInfo = new Application("", "", "", "", "",
                    0, 0, 0, "", "", "", "");
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appInfo;
    }

    @Override
    public void updateStatusById(String appId, int status) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE CloudComputing.applications SET status=" + status + " WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateStatusById]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public void updateVisitByContext(String appContext, Integer newVisits) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "UPDATE CloudComputing.applications SET visits=" + newVisits + " WHERE contextPath='" + appContext + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.ApplicationDaoImpl.updateVisitByContext]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }
}

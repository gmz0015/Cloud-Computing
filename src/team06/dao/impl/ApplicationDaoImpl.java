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
            String sql = "SELECT appid,appname,ownerid,visits,rating,status FROM CloudComputing.applications";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                username = userBean.getUserNameById(rs.getInt("ownerid"));
                appsInfo.add(new Application(rs.getInt("appid"), rs.getString("appname"), rs.getInt("ownerid"),
                        username, rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status")));
            }
        }catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return appsInfo;
    }
}

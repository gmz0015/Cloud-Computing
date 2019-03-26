package javabean;

import team06.domain.Application;
import team06.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationBean extends HttpServlet implements Serializable {
    private List<Application> appsInfo;

    public ApplicationBean() {
        appsInfo = new ArrayList<Application>();

        UserBean userBean = new UserBean();
        String username;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT appid,name,ownerid,visits,rating,status FROM CloudComputing.applications";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                username = userBean.getUserNameById(rs.getInt("ownerid"));
                appsInfo.add(new Application(rs.getInt("appid"), rs.getString("name"), rs.getInt("ownerid"),
                        username, rs.getInt("visits"), rs.getDouble("rating"), rs.getInt("status")));
            }
        }catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public void init() throws ServletException {

    }

    /**
     * get all applications
     */
    public List<Application> getApplications() {
        return appsInfo;
    }

    /**
     * For debug
     * @param args
     */
    public static void main(String[] args) {
        ApplicationBean user = new ApplicationBean();
    }
}

package javabean;

import java.io.IOException;
import java.io.Serializable;
import team06.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class UserBean extends HttpServlet implements Serializable {
    private String submit;
    private HashMap<String, String> userInfo;

    public UserBean() {
        userInfo = new HashMap<String, String>();
    }

    /**
     * For debug
     * @param args
     */
    public static void main(String[] args) {
        double rating1 = 4.3;
        double rating2 = 4.6;
        double rating3 = 4.5;

        int unit = (int) rating1;

        System.out.println("1 is: " + (int) rating1);
        System.out.println("2 is: " + (int) (rating2*10 - unit*10));
        System.out.println("3 is: " + (int) rating3);
    }

    @Override
    public void init() throws ServletException {
    }


    /**
     * get all users' name and userid
     * store in Map<String, String>
     * @return (user id, user name)
     */
    public Map<String, String> getUsersName() {
        Map<String, String> usersName = new HashMap<String, String>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT userid,username FROM CloudComputing.users";
            st = conn.prepareStatement(sql);
//            st.setInt(1, 1);
            rs = st.executeQuery();
            while (rs.next()){
                usersName.put(rs.getString("userid"), rs.getString("username"));
            }
        }catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return usersName;
    }

    /**
     * get username by userid
     */
    public String getUserNameById(int userid) {
        String username = "";
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT username FROM CloudComputing.users WHERE userid=" + userid;
            st = conn.prepareStatement(sql);
//            st.setInt(1, 1);
            rs = st.executeQuery();
            while (rs.next()){
                username = rs.getString("username");
            }
        }catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return username;
    }


    /**
     * set current user and change related info
     */
    public void setUser(String userid){
        /* query database */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM CloudComputing.users WHERE userid=" + userid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            /* Update userInfo */
            while (rs.next()) {
                System.out.println("username is: " + rs.getString("username") + ". displayname is: " + rs.getString("displayname"));
                userInfo.put("username", rs.getString("username"));
                userInfo.put("email", rs.getString("email"));
                userInfo.put("birthday", rs.getString("birthday"));
                userInfo.put("displayname", rs.getString("displayname"));
            }

        }catch (Exception e) {
            System.out.println("Catch Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }


    /* REMOVE */
    /**
     * get the user info
     * @return
     */
    public HashMap<String, String> getUserInfo() {
        return userInfo;
    }

    public void doAction(HttpServletRequest request) {
        if (request.getParameter("submit") == null)
            System.out.println("null");
        else if (request.getParameter("submit").equals("switch User")){
            setUser(request.getParameter("userNameList"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set response type
        if (request.getParameter("submit").equals("switch User")) {
            System.out.println("setUser");
            setUser(request.getParameter("userNameList"));
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

/**
 * Backup
 */
//Iterator<Map.Entry<String, String>> usersNameIterator = userInfo.entrySet().iterator();
//                while (usersNameIterator.hasNext()) {
//                        Map.Entry<String, String> userName = usersNameIterator.next();
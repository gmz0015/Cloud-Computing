package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class User extends HttpServlet implements Serializable {
    private String submit;
    private HashMap<String, String> userInfo;

    public User() {
        userInfo = new HashMap<String, String>();
    }

    /**
     * For debug
     * @param args
     */
    public static void main(String[] args) {
        User user = new User();
        user.setUser("1");
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
            String sql = "SELECT userid,name FROM CloudComputing.users";
            st = conn.prepareStatement(sql);
//            st.setInt(1, 1);
            rs = st.executeQuery();
            while (rs.next()){
                usersName.put(rs.getString("userid"), rs.getString("name"));
            }
        }catch (Exception e) {

        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return usersName;
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
                userInfo.put("username", rs.getString("name"));
                userInfo.put("email", rs.getString("email"));
                userInfo.put("birthday", rs.getString("birthday"));
            }

        }catch (Exception e) {
            System.out.println("Catch Exception: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }


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
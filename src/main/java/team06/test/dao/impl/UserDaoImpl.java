package team06.test.dao.impl;

import team06.test.dao.IUserDao;
import team06.test.domain.User;
import team06.test.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    public List<User> queryAllUsers() {
        List<User> users = new LinkedList<User>();

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM users";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                users.add(new User(rs.getString("userid"), rs.getString("username"), rs.getString("password"), rs.getString("role")));
            }
        }catch (Exception e) {
            System.out.println("[team06.test.dao.impl.UserDaoImpl.queryAllUsers]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return users;
    }

    public User queryUserByID(String userid) {
        User user = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM users WHERE userid=" + userid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                user = new User(userid, rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        }catch (Exception e) {
            System.out.println("[team06.test.dao.impl.UserDaoImpl.queryUserByID]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return user;
    }

    @Override
    public User queryUserByUsername(String username) {
        User user = null;

        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM users WHERE username='" + username + "'";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                user = new User(rs.getString("userid"), username, rs.getString("password"), rs.getString("role"));
            }
        }catch (Exception e) {
            System.out.println("[team06.test.dao.impl.UserDaoImpl.queryUserByUsername]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return user;
    }
}

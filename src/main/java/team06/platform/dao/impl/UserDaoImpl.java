package team06.platform.dao.impl;

import team06.platform.dao.IUserDao;
import team06.platform.domain.User;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao {
    @Override
    public Boolean insertUser(User user) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "INSERT INTO " +
                    "CloudComputing.users " +
                    "VALUES (" +
                    user.getUserId() + ", " +
                    "'" + user.getUserName() + "', " +
                    "'" + user.getPassword() + "', " +
                    "'" + user.getEmail() + "', " +
                    "'" + user.getAvatar() + "', " +
                    "'" + user.getUserRole() + "');";
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();
            String sql1 = "INSERT INTO " +
                    "CloudComputing.user_roles " +
                    "VALUES (" +
                    "'" + user.getUserName() + "', " +
                    "'" + user.getUserRole() + "');";
            st = conn.prepareStatement(sql1);
            st.execute();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.insertUser]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public User queryUserInfoByName(String userName) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.users WHERE user_name='" + userName + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while(rs.next()) {
                user = new User(rs.getLong("user_id"), rs.getString("user_name"), rs.getString("user_pass"),
                        rs.getString("email"), rs.getString("avatar"), rs.getString("user_role"));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.queryUserInfoByName]: " + e);
            user = new User(Long.valueOf("0"), "", "",
                    "", "", "");
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return user;
    }

    @Override
    public User queryUserInfoById(String userId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.users WHERE user_id='" + userId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while(rs.next()) {
                user = new User(rs.getLong("user_id"), rs.getString("user_name"), rs.getString("user_pass"),
                        rs.getString("email"), rs.getString("avatar"), rs.getString("user_role"));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.queryUserInfoById]: " + e);
            user = new User(Long.valueOf("0"), "", "",
                    "", "", "");
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return user;
    }

    @Override
    public User queryUserInfo(String userName, String password) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.users WHERE user_name='" + userName + "' AND user_pass='" + password + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while(rs.next()) {
                user = new User(rs.getLong("user_id"), rs.getString("user_name"), rs.getString("user_pass"),
                        rs.getString("email"), rs.getString("avatar"), rs.getString("user_role"));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.queryUserInfo]: " + e);
            user = new User(Long.valueOf("0"), "", "",
                    "", "", "");
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return user;
    }

    @Override
    public Boolean updateUserPassword(String userId, String password) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "UPDATE CloudComputing.users SET user_pass='" + password + "' WHERE user_id='" + userId + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.updateUserPassword]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public Boolean updateUserEmail(String userId, String email) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "UPDATE CloudComputing.users SET email='" + email + "' WHERE user_id='" + userId + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.updateUserEmail]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public Boolean updateUserAvatar(String userId, String avatarPath) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "UPDATE CloudComputing.users SET avatar='" + avatarPath + "' WHERE user_id='" + userId + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.updateUserAvatar]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public Boolean updateUserRole(String userId, String userName, String role) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql1 = "UPDATE CloudComputing.users SET user_role='" + role + "' WHERE user_id='" + userId + "';";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            String sql2 = "UPDATE CloudComputing.user_roles SET user_role='" + role + "' WHERE user_name='" + userName + "';";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.UserDaoImpl.updateUserRole]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }
}

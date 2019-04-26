package team06.platform.dao.impl;

import team06.platform.dao.IUserDao;
import team06.platform.domain.User;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao {
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
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return user;
    }
}

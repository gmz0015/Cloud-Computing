package team06.platform.dao.impl;

import team06.platform.dao.IAccountDao;
import team06.platform.domain.Account;
import team06.platform.domain.Transaction;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public Integer queryBalance(String userid) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Integer balance = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT balance FROM CloudComputing.account WHERE userid='" + userid + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while (rs.next()) {
                balance = rs.getInt("balance");
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.queryBalance]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return balance;
    }

    @Override
    public boolean updateBalance(Account account) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "UPDATE CloudComputing.account SET balance='" + account.getBalance() + "' WHERE userid='" + account.getUserid() + "';";
            st = conn.prepareStatement(sql);
            st.executeUpdate();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.updateBalance]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public boolean insertTransaction(Transaction transaction) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "INSERT INTO" +
                    "CloudComputing.transaction " +
                    "VALUES " +
                    "fromUserId='" + transaction.getFromUserId() + "' " +
                    "fromUserName='" + transaction.getFromUserName() + "' " +
                    "toUserId='" + transaction.getToUserId() + "' " +
                    "toUserName='" + transaction.getToUserName() + "' " +
                    "'type'='" + transaction.getType() + "' " +
                    "'appId'='" + transaction.getAppId() + "' " +
                    "'number'='" + transaction.getAmount() + "' " +
                    ";";
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.insertTransaction]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }
}

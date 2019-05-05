package team06.platform.dao.impl;

import team06.platform.dao.IAccountDao;
import team06.platform.domain.Account;
import team06.platform.domain.Charge;
import team06.platform.domain.Transaction;
import team06.platform.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void insertAccount(Long userId, String userName) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "INSERT INTO " +
                    "CloudComputing.account " +
                    "VALUES (" +
                    userId + ", " +
                    "'" + userName + "', " +
                    1000 + ");";
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.insertAccount]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    @Override
    public Double queryBalance(Long userId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Double balance = null;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT balance FROM CloudComputing.account WHERE userId='" + userId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while (rs.next()) {
                balance = rs.getDouble("balance");
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

            String sql = "UPDATE CloudComputing.account SET balance='" + account.getBalance() + "' WHERE userId='" + account.getUserId() + "';";
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
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "INSERT INTO " +
                    "CloudComputing.transaction " +
                    "VALUES (" +
                    0 + ", " +
                    transaction.getFromUserId() + ", " +
                    "'" + transaction.getFromUserName() + "', " +
                    transaction.getToUserId() + ", " +
                    "'" + transaction.getToUserName() + "', " +
                    "'" + transaction.getType() + "', " +
                    transaction.getAppId() + ", " +
                    transaction.getAmount() + ", " +
                    "'" + transaction.getTime() + "');";
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

    @Override
    public boolean insertCharge(Charge charge) {
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
                    "CloudComputing.charge " +
                    "VALUES (" +
                    charge.getUserId() + ", " +
                    charge.getAppId() + ");";
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.insertCharge]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public boolean deleteCharge(Long userId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean result = false;

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "DELETE FROM CloudComputing.charge WHERE userId=" + userId + ";";
            st = conn.prepareStatement(sql);
            st.execute();
            conn.commit();
            result = true;
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.deleteCharge]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return result;
    }

    @Override
    public List<Charge> queryCharge(Long userId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Charge> charge = new ArrayList<>();

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.charge WHERE userId='" + userId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while(rs.next()) {
                charge.add(new Charge(rs.getLong("userId"), rs.getLong("appId")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.queryCharge]: " + e);
            charge.add(new Charge(Long.valueOf(0), Long.valueOf(0)));
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return charge;
    }

    @Override
    public List<Transaction> queryTransaction(Long userId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Transaction> transactions = new ArrayList<>();

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.transaction WHERE fromUserId='" + userId + "' OR toUserId='" + userId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while(rs.next()) {
                transactions.add(new Transaction(
                        rs.getLong("fromUserId"), rs.getString("fromUserName"),
                        rs.getLong("toUserId"), rs.getString("toUserName"),
                        rs.getString("type"), rs.getLong("appId"),
                        rs.getDouble("number"), rs.getTimestamp("time")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.queryTransaction]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return transactions;
    }

    @Override
    public List<Transaction> queryAppTransaction(Long appId) {
        /* Initial Connection */
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Transaction> transactions = new ArrayList<>();

        /* Connect */
        try{
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false); // start transaction

            String sql = "SELECT * FROM CloudComputing.transaction WHERE appId='" + appId + "';";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            conn.commit();
            while(rs.next()) {
                transactions.add(new Transaction(
                        rs.getLong("fromUserId"), rs.getString("fromUserName"),
                        rs.getLong("toUserId"), rs.getString("toUserName"),
                        rs.getString("type"), rs.getLong("appId"),
                        rs.getDouble("number"), rs.getTimestamp("time")));
            }
        }catch (Exception e) {
            System.out.println("[team06.platform.dao.impl.AccountDaoImpl.queryTransaction]: " + e);
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return transactions;
    }
}

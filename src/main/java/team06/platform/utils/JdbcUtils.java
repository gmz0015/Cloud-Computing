package team06.platform.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Date;

public class JdbcUtils {

    private static DataSource ds = null;
    // Create connection pool
    static{
        try{
            // Initial JNDI
            Context initCtx = new InitialContext();
            // Get JNDI container
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Retrieval the datasource named "jdbc/datasource" from JNDI container
            ds = (DataSource)envCtx.lookup("jdbc/datasource");
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * @Method: getConnection
     * @Description: get connection object from datasource
     *
     * @return Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
//        System.out.printf("[%-23s] Create Connection\n", new Timestamp(new Date().getTime()));
        return ds.getConnection();
    }

    /**
     * @Method: release
     * @Description: release source,
     *     release connection, Statement, ResultSet
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void release(Connection conn,Statement st,ResultSet rs){
//        System.out.printf("[%-23s] Release Connection\n", new Timestamp(new Date().getTime()));
        if(rs!=null){
            try{
                //close ResultSet Object
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //close Statement Object
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //close connection
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

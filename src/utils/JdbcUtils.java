package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

    private static String driver = null;
    private static String url = "jdbc:mysql://localhost:3306/CloudComputing";
    private static String username = "root";
    private static String password = "Gmz110803";

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * @Method: getConnection
     * @Description: get connection object
     *
     * @return Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username,password);
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
        if(rs!=null){
            try{
                //close ResultSet
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //close Statement
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

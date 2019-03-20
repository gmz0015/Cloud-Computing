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
            //读取db.properties文件中的数据库连接信息
//            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
//            Properties prop = new Properties();
//            prop.load(in);
//
//            //获取数据库连接驱动
//            driver = prop.getProperty("driver");
//            //获取数据库连接URL地址
//            url = "jdbc:mysql://localhost:3306/imooc";
//            //获取数据库连接用户名
//            username = "root";
//            //获取数据库连接密码
//            password = "Gmz110803";
//
//            System.out.println(driver);
//            System.out.println(url);
//            System.out.println(username);
//            System.out.println(password);
//
//            //加载数据库驱动
//            Class.forName(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("oracle.jdbc.driver.OracleDriver");

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

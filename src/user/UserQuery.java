package user;

import net.sf.json.JSONObject;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName: UserQuery
 * @Description: 通过PreparedStatement对象完成对数据库的CRUD操作
 * @author: Mingze Gao
 * @date: 2018-03-20
 *
 */
public class UserQuery {

    /**
     * For test
     * @param args
     */
    public static void main(String[] args) {
        UserQuery demo = new UserQuery();
        JdbcUtils JDBC = new JdbcUtils();
        demo.find("1");
    }

    /**
     * insert user to database
     */
    public void insert(){}

    public JSONObject find(String userid){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        JSONObject json = new JSONObject();
        try{
            conn = JdbcUtils.getConnection();
            String sql = "select * from users where userid=" + userid;
            st = conn.prepareStatement(sql);
//            st.setInt(1, 1);
            rs = st.executeQuery();
            while (rs.next()){
                json.put("username", rs.getString("name"));
                json.put("email", rs.getString("email"));
                json.put("birthday", rs.getString("birthday"));
            }
        }catch (Exception e) {

        }finally{
            JdbcUtils.release(conn, st, rs);
        }
        return json;
    }

    public void delete(){}

    public void edit(){}
}

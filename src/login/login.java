package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        String userName = request.getParameter("username").trim();
        String userPwd = request.getParameter("userpassword").trim();

        if(userName == null || userPwd == null) {
            response.sendRedirect("userlogin.html");
        }

        try {
            //Step 1: create URL
            URL url = new URL("http://localhost:9528/test/api/user/login");
            //Step 2: open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //Step 3: set parameters
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            out = null;

            out = new PrintWriter(connection.getOutputStream());
            // flush输出流的缓冲
            out.print("username=" + userName + "&password=" + userPwd);
            out.flush();


            //Step 4: receive response from server
            int responseCode = connection.getResponseCode();
            System.out.println("code is: " + connection.getResponseCode());
            System.out.println("message is: " + connection.getResponseMessage());
            System.out.println("content type is: " + connection.getContentType());
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println("result is:" + result);
        }catch (Exception e) {
            System.out.println("Catch Exception: " + e);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

//        if(200 == responseCode){
//            System.out.println(connection.getResponseMessage());
//        }

//        if(userName.equals(USERNAME) && userPwd.equals(USERPWD)) {
//            request.getSession().setMaxInactiveInterval(30*60);		// 设置session失效时间（timeout），单位为秒
//            request.getSession().setAttribute("userinfo", USERNAME);		// 用户名和密码正确，保存登录信息(获得session与jsp网页稍有不同)
//            response.sendRedirect("index.jsp");
//        } else {
//            response.sendRedirect("userlogin.html");			// 用户名和密码错误，跳转到登录界面
//        }
    }
}
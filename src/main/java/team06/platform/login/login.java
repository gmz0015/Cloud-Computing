package team06.platform.login;

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

    // Production
//    private String IP = "8080";

    // Development
    private String IP = "9527";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        System.out.println("requestURI is: " + request.getRequestURI());
        System.out.println("requestURL is: " + request.getRequestURL());
        System.out.println("remoteAddr is: " + request.getRemoteAddr());

        String userName = request.getParameter("username").trim();
        String userPwd = request.getParameter("userpassword").trim();

        try {
            //Step 1: create URL
            URL url = new URL("http://localhost:" + IP + "/test/api/user/login");
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

            // Set session
            if (result.equals("0")) {
                System.out.println("[login.login.doPost]: Username is not right");
            } else if (result.equals("1")) {
                System.out.println("[login.login.doPost]: Password is not right");
            } else {
                String[] userinfo = result.split("&");
                request.getSession().setMaxInactiveInterval(30*60);
                request.getSession().setAttribute("userid", userinfo[0]);
                request.getSession().setAttribute("username", userinfo[1]);
                request.getSession().setAttribute("userrole", userinfo[2]);
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            System.out.println("Catch Exception: " + e);
        } finally {
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
    }
}
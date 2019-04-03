import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class testJMX extends HttpServlet {

    public testJMX() {}

//    public static void main(String[] args) {
//        testJMX t = new testJMX();
//        t.tomcat();
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        URL url = new URL("http://localhost:9528/manager/text/list");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        System.out.println("Start Test");

        try {
            conn.setAllowUserInteraction(false);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setDoOutput(false);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String username = "tomcat2";
            String password = "tomcat";
            String authoInfo = new String(Base64.encode((username + ":" + password).getBytes()));
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();

            InputStream input = conn.getInputStream();
            System.out.println("conn is: " + conn);
            System.out.println("input is: " + input);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            byte[] bs = new byte[1024];
            int len = -1;

            int j = 0;
            while ((len = input.read(bs)) != -1) {
                System.out.println(j++ + ": " + new String(bs, 0, len));
                    out.write(new String(bs, 0, len));
            }
            out.flush();
            out.close();
        }
        catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }

    }
}

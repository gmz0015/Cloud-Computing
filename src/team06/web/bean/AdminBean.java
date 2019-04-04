package team06.web.bean;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import team06.domain.AppsInfo;
import team06.domain.DBUser;
import team06.domain.Database;
import team06.service.IAdminService;
import team06.service.impl.AdminServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class AdminBean extends HttpServlet implements Serializable {
    private IAdminService adminService = new AdminServiceImpl();

    public AdminBean() {}

    public List<AppsInfo> listAllApps() {
        List<AppsInfo> appsInfo = new LinkedList<>();
        try {
            URL url = new URL("http://localhost:9527/manager/text/list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

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

            byte[] bs = new byte[1024];
            int len = -1;

            String temp = "";
            while ((len = input.read(bs)) != -1) {
                temp += new String(bs, 0, len);
            }

            String[] temp_split = temp.split(" |\n");
            String[] temp_app;
            int j=0;
            for (int i=8; i<temp_split.length; i++) {
                temp_app = temp_split[i].split(":");
                appsInfo.add(new AppsInfo(temp_app[0], temp_app[1], temp_app[2], temp_app[3]));
            }
        }
        catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }
        return appsInfo;
    }

    public List<DBUser> getAllUsers() {
        return adminService.queryAllUsers();
    }

    public List<Database> queryDB() {
        return adminService.queryAllDBs();
    }
}

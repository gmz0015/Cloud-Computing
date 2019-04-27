package team06.platform.web.bean;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import team06.platform.domain.AppsInfo;
import team06.platform.domain.DBUser;
import team06.platform.domain.Database;
import team06.platform.service.IAdminService;
import team06.platform.service.impl.AdminServiceImpl;

import javax.servlet.http.HttpServlet;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class AdminBean extends HttpServlet implements Serializable {
    // Production
//    private String PORT = "8080";
//    private String USERNAME = "tomcatscript";
//    private String PASSWORD = "tomcat";

    // Development
    private String PORT = "9527";
    private String USERNAME = "tomcat2";
    private String PASSWORD = "tomcat";


    private IAdminService adminService = new AdminServiceImpl();

    public AdminBean() {}

    public List<AppsInfo> listAllApps() {
        List<AppsInfo> appsInfo = new LinkedList<>();
        try {
            URL url = new URL("http://localhost:" + PORT + "/manager/text/list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setAllowUserInteraction(false);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setDoOutput(false);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String authoInfo = new String(Base64.encode((USERNAME + ":" + PASSWORD).getBytes()));
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

    public List<Database> getDB() {
        return adminService.queryAllDBs();
    }
}

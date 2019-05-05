package team06.platform.web.bean;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import team06.platform.domain.AppsInfo;
import team06.platform.domain.DBUser;
import team06.platform.domain.Database;
import team06.platform.service.IAdminService;
import team06.platform.service.impl.AdminServiceImpl;
import team06.platform.utils.ConfigUtils;

import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.*;

public class AdminBean extends HttpServlet  {
    private ConfigUtils configUtils = new ConfigUtils();
    private String PORT;
    private String USERNAME;
    private String PASSWORD;


    private IAdminService adminService = new AdminServiceImpl();

    public AdminBean() {
        Map<String, String> temp = configUtils.getConfig();
        this.PORT = temp.get("PORT");
        this.USERNAME = temp.get("USERNAME");
        this.PASSWORD = temp.get("PASSWORD");
    }

    public List<AppsInfo> listAllApps() {
        List<AppsInfo> appsInfo = new LinkedList<>();
        try {
            URL url = new URL("http://localhost:" + PORT + "/manager/text/list");
            URLConnection conn = (URLConnection) url.openConnection();
            String authoInfo = Base64.encode((USERNAME + ":" + PASSWORD).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
            conn.connect();

            InputStream input = conn.getInputStream();
            BufferedReader bufreader = new BufferedReader(new InputStreamReader(input));
            String line = null;
            List<String> dataResult = new ArrayList<>();
            int i = 0;
            while ((line = bufreader.readLine()) != null) {
                if (i != 0) {
                    dataResult.add(line);
                }
                i++;
            }

            String[] temp_app;
            for (String result: dataResult) {
                temp_app = result.split(":");
                appsInfo.add(new AppsInfo(temp_app[0], temp_app[1], temp_app[2], temp_app[3]));
            }
        }
        catch (Exception e) {
            System.out.printf("[%-23s][%-20s][%-20s] Catch Exception: %s\n", new Timestamp(new Date().getTime()), "AdminBean", "listAllApps", e);
            e.printStackTrace();
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

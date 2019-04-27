package team06.platform.web.controller;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10, // 10MB
        maxRequestSize=1024*1024*50) // 50MB
public class ManagerServlet {
    // Production
//    private String PORT = "8080";
//    private String USERNAME = "tomcatscript";
//    private String PASSWORD = "tomcat";

    // Development
    private String PORT = "9527";
    private String USERNAME = "tomcat2";
    private String PASSWORD = "tomcat";
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public ManagerServlet() {}


    public String upload(String savePath, Part part) throws IOException {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        File fileSaveDir = new File(savePath);
        String deployPath = "";

        if (!fileSaveDir.exists())
            fileSaveDir.mkdir();


        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String fileName = s.substring(s.indexOf("=") + 2, s.indexOf("."));
                String fileType = s.substring(s.indexOf(".") + 1, s.length() - 1);
                String saveName;
                if (fileType.equals("war")) {
                    System.out.println("Is war");
                    saveName = fileName + "_" + System.currentTimeMillis() + "." + fileType;
                    part.write(savePath + File.separator + saveName);
                } else {
                    // For test, REMOVE AFTER FINISH
                    System.out.println("Not war");
                    saveName = fileName + "_" + System.currentTimeMillis() + "." + fileType;
                    part.write(savePath + File.separator + saveName);
//                        return "Failed Upload: Wrong File Type";
                }
                deployPath = savePath + File.separator + saveName;
            }
        }
        return deployPath;
    }

    /**
     * Deploy an application from directory to target path
     * @param war_path the war file path where the application is located
     * @param target_path the context path on tomcat server
     * @return
     */
    public String deploy(String appid, String war_path, String target_path) {
        String message = "";
        try {
            URL url = new URL("http://localhost:" + PORT + "/manager/text/deploy?path=" + target_path + "&war=file:" + war_path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setAllowUserInteraction(false);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setDoOutput(false);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String authoInfo = Base64.encode((USERNAME + ":" + PASSWORD).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
//            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();

            InputStream input = conn.getInputStream();
            byte[] bs = new byte[1024];
            int len = -1;

            while ((len = input.read(bs)) != -1) {
                message += new String(bs, 0, len);
            }
            String[] temp = message.split(" - ");

            if (temp[0].equals("OK")) {
                applicationService.setContextById(appid, target_path);
                applicationService.setStatusById(appid, 2);
            }

        } catch (MalformedURLException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.deploy]: " + e);
        } catch (ProtocolException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.deploy]: " + e);
        } catch (IOException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.deploy]: " + e);
        }
        return message;
    }

    /**
     * Undeploy an application based on appid
     * @param appid
     * @return
     */
    public String undeploy(String appid, String context) {
        String message = "";
        try {
            URL url = new URL("http://localhost:" + PORT + "/manager/text/undeploy?path=" + context);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setAllowUserInteraction(false);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setDoOutput(false);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String authoInfo = Base64.encode((USERNAME + ":" + PASSWORD).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
//            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();

            InputStream input = conn.getInputStream();
            byte[] bs = new byte[1024];
            int len = -1;

            while ((len = input.read(bs)) != -1) {
                message += new String(bs, 0, len);
            }
            String[] temp = message.split(" - ");

            if (temp[0].equals("OK")) {
                // Update database
                applicationService.setContextById(appid, null);
                applicationService.setStatusById(appid, 0);
            }
        } catch (MalformedURLException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.undeploy]: " + e);
        } catch (ProtocolException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.undeploy]: " + e);
        } catch (IOException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.undeploy]: " + e);
        }
        return message;

    }

    /**
     * start an application based on its context path
     * @param context
     * @return
     */
    public String start(String appid, String context) {
        String message = "";
        try {
            URL url = new URL("http://localhost:" + PORT + "/manager/text/start?path=" + context);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setAllowUserInteraction(false);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setDoOutput(false);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String authoInfo = Base64.encode((USERNAME + ":" + PASSWORD).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
//            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();

            InputStream input = conn.getInputStream();
            byte[] bs = new byte[1024];
            int len = -1;

            while ((len = input.read(bs)) != -1) {
                message += new String(bs, 0, len);
            }
            String[] temp = message.split(" - ");

            if (temp[0].equals("OK")) {
                // Update database
                applicationService.setStatusById(appid, 2);
            }
        } catch (MalformedURLException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.start]: " + e);
        } catch (ProtocolException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.start]: " + e);
        } catch (IOException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.start]: " + e);
        }
        return message;
    }

    /**
     * stop an application based on its context path
     * @param context
     * @return
     */
    public String stop(String appid, String context) {
        String message = "";
        try {
            URL url = new URL("http://localhost:" + PORT + "/manager/text/stop?path=" + context);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setAllowUserInteraction(false);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            conn.setDoOutput(false);
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String authoInfo = Base64.encode((USERNAME + ":" + PASSWORD).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
//            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();

            InputStream input = conn.getInputStream();
            byte[] bs = new byte[1024];
            int len = -1;

            while ((len = input.read(bs)) != -1) {
                message += new String(bs, 0, len);
            }
            String[] temp = message.split(" - ");

            if (temp[0].equals("OK")) {
                // Update database
                applicationService.setStatusById(appid, 1);
            }
        } catch (MalformedURLException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.stop]: " + e);
        } catch (ProtocolException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.stop]: " + e);
        } catch (IOException e) {
            System.out.println("[team06.platform.service.impl.ManagerService.stop]: " + e);
        }
        return message;
    }

    public String delete(String appid, String context) {
        String message = undeploy(appid, context);
        String[] temp = message.split(" - ");
        applicationService.deleteAppByAppId(appid);
        return message;
    }
}

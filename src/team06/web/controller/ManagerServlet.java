package team06.web.controller;

import com.sun.org.apache.xml.internal.security.utils.Base64;

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
    public void deploy(String war_path, String target_path) {
        try {
            URL url = new URL("http://localhost:9528/manager/text/deploy?path=" + target_path + "&war=file:" + war_path);
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
            String authoInfo = Base64.encode((username + ":" + password).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + authoInfo);
//            conn.setRequestProperty("Connection", "keep-alive");
            conn.connect();

            InputStream input = conn.getInputStream();
            byte[] bs = new byte[1024];
            int len = -1;

            String message = "";
            while ((len = input.read(bs)) != -1) {
                message += new String(bs, 0, len);
            }
            System.out.println("message is: " + message);
        } catch (MalformedURLException e) {
            System.out.println("[team06.service.impl.ManagerService.deploy]: " + e);
        } catch (ProtocolException e) {
            System.out.println("[team06.service.impl.ManagerService.deploy]: " + e);
        } catch (IOException e) {
            System.out.println("[team06.service.impl.ManagerService.deploy]: " + e);
        }
    }

    /**
     * Undeploy an application based on its context path
     * @param context_path
     * @return
     */
    public void undeploy(String context_path) {

    }

    /**
     * start an application based on its context path
     * @param context_path
     * @return
     */
    public void start(String context_path) {

    }

    /**
     * stop an application based on its context path
     * @param context_path
     * @return
     */
    public void stop(String context_path) {

    }
}

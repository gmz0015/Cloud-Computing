package team06.web.bean;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import team06.dao.IDatabaseDao;
import team06.dao.impl.DatabaseDaoImpl;
import team06.domain.Database;
import team06.service.IDatabaseService;
import team06.service.impl.DatabaseServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10, // 10MB
        maxRequestSize=1024*1024*50) // 50MB
public class AppCreateBean implements Serializable {
    private int uploadStatus = 0;
    private int deployStatus = 0;
    private int startupStatus = 0;
    private final String SAVE_DIR = "uploadedFiles";
    private int nextStep = 0;
    private IDatabaseService databaseService = new DatabaseServiceImpl();


    public Database queryDBbyid(int userid) {
        nextStep = 1;
        return databaseService.queryDBbyid(userid);
    }

    public void doDeploy(HttpServletRequest request) {
        System.out.println("Start Deploy Process");
        String appPath = request.getServletContext().getRealPath("");

        try {
            System.out.println(request.getParts());
            for (Part part : request.getParts()) {

                // Invoke upload process
                uploadApp(appPath, part);
            }
        }catch (Exception e) {
            System.out.println("[team06.web.bean.AppCreateBean.doDeploy]: " + e);
        }
    }

    /**
     * upload file
     * @param appPath the path of saving file
     * @param part the file
     * @return upload status
     */
    public String uploadApp(String appPath, Part part) {
        System.out.println("Start Upload");
        String savePath = appPath + SAVE_DIR;

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        File fileSaveDir = new File(savePath);
        String deployPath = "";

        if (!fileSaveDir.exists())
            fileSaveDir.mkdir();

        try {
            for (String s : items) {
                if (s.trim().startsWith("filename")) {
                    String fileName = s.substring(s.indexOf("=") + 2, s.indexOf("."));
                    String fileType = s.substring(s.indexOf(".") + 1, s.length()-1);
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

                    // Update the upload is successful
                    uploadStatus = 2;

                    // Invoke deploy process
                    deploy(deployPath);
                }
            }
        }catch (Exception e) {
            System.out.println("Catch Exception: " + e);
            return "";
        }
        return deployPath;
    }

    /**
     * deploy the application baseb on path
     * @param filePath
     * @throws IOException
     */
    private void deploy(String filePath) throws IOException {
        System.out.println("Start Deploy");
        URL url = new URL("http://localhost:9528/manager/text/deploy?path=/footoo&war=file:" + filePath.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

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
            byte[] bs = new byte[1024];
            int len = -1;

            String message = "";
            while ((len = input.read(bs)) != -1) {
                message += new String(bs, 0, len);
            }
            System.out.println("message is: " + message);

            // Update the deploy is successful
            deployStatus = 2;

            // Invoke startup process
            startup("/footoo");
        }
        catch (Exception e) {
            System.out.println("Catch a Exception: " + e);
        }
    }

    private void startup(String appPath) {
        // Update the startup is successful
        startupStatus = 2;

        // Update the next step to Allocate Database
        nextStep = 2;
    }


    /* Getter and Setter */
    public int getNextStep() { return nextStep; }

    public int getStartupStatus() { return startupStatus; }

    public int getDeployStatus() { return deployStatus; }

    public int getUploadStatus() { return uploadStatus; }
}

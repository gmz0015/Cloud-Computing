package team06.platform.web.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Application;
import team06.platform.service.IDatabaseService;
import team06.platform.service.IManagerService;
import team06.platform.service.impl.DatabaseServiceImpl;
import team06.platform.service.impl.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10, // 10MB
        maxRequestSize=1024*1024*50) // 50MB
public class CreateNewAppServlet extends HttpServlet {
    private final String SAVE_DIR = "uploadedFiles";
    private ManagerServlet managerServlet = new ManagerServlet();
    private IManagerService managerService = new ManagerService();
    private IDatabaseService databaseService = new DatabaseServiceImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = null;
        String userName = null;
        String userRole = null;
        String token = null;

        Cookie[] cs = request.getCookies();
        if(cs != null) {
            for(Cookie c : cs) {
                if(c.getName().equals("token")) {
                    token = c.getValue();
                }
            }
        }
        if (token != null) {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            userId = jwt.getClaim("userId").asString();
            userName = jwt.getClaim("userName").asString();
            userRole = jwt.getClaim("userRole").asString();
        }

        String appPath = request.getServletContext().getRealPath("");
        if (request.getContentType() != null) {
            if (request.getContentType().split(";")[0].equals("multipart/form-data")) {
                for (Part part : request.getParts()) {
                    if (part.getName().equals("file")) {

                        try {

                            // Invoke upload process
                            String savePath = managerServlet.upload(appPath + SAVE_DIR, part);

                            // Insert to database
                            managerService.insertNewApp(new Application(
                                    generateAppid(),
                                    userName + "_" + generateAppid(),
                                    "Default Description",
                                    userId,
                                    userName,
                                    0,
                                    0.0,
                                    0,
                                    databaseService.queryDBbyid(userId, userName).getDbId(),
                                    savePath,
                                    null,
                                    "/image/defalutAPP.jpg"));
                        }catch (Exception e) {
                            System.out.println("[team06.platform.web.controller.CreateNewAppServlet.doGet]: " + e);

                            // Upload Failed, dispatch back
                            response.sendRedirect(request.getContextPath() + "/application?error=0");
                        }

                        // Upload Successful, redirect to application page
                        response.sendRedirect("/application?error=1");
                    }
                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String generateAppid() {
        return String.valueOf(System.currentTimeMillis());
    }
}

package team06.platform.web.controller;

import team06.platform.domain.Application;
import team06.platform.service.IDatabaseService;
import team06.platform.service.IManagerService;
import team06.platform.service.impl.DatabaseServiceImpl;
import team06.platform.service.impl.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10, // 10MB
        maxRequestSize=1024*1024*50) // 50MB
public class CreateNewAppServlet extends HttpServlet {
    private final String SAVE_DIR = "uploadedFiles";
    private ManagerServlet managerServlet = new ManagerServlet();
    private IManagerService managerService = new ManagerService();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                                    request.getSession().getAttribute("userId") + "_" + generateAppid(),
                                    "Default Description",
                                    request.getSession().getAttribute("userId").toString(),
                                    request.getSession().getAttribute("userName").toString(),
                                    0,
                                    0.0,
                                    0,
                                    databaseService.queryDBbyid(request.getSession().getAttribute("userid").toString()).getDbId(),
                                    savePath,
                                    null,
                                    "/image/defalutAPP.jpg"));
                        }catch (Exception e) {
                            System.out.println("[team06.platform.web.controller.CreateNewAppServlet.doGet]: " + e);

                            // Upload Failed, dispatch back
                            request.setAttribute("error", 1);
                            request.getRequestDispatcher("/WEB-INF/pages/views/applicationCreate.jsp").forward(request, response);
                        }

                        // Upload Successful, redirect to application page
                        response.sendRedirect("/application");
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

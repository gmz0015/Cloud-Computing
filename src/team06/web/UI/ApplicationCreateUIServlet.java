package team06.web.UI;


import team06.web.bean.ApplicationBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10, // 10MB
        maxRequestSize=1024*1024*50) // 50MB
public class ApplicationCreateUIServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check whether is developer
        if (true) {
            HttpSession session = request.getSession();
            request.getRequestDispatcher("/WEB-INF/pages/views/applicationCreate.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/?error=0");
        }
    }
    private static final String SAVE_DIR = "uploadedFiles";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

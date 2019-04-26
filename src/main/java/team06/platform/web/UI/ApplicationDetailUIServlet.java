package team06.platform.web.UI;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationDetailUIServlet extends HttpServlet {
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String appId = request.getParameter("appId");
        String userId = request.getSession().getAttribute("userId").toString();

        // Check whether the user ownes this application
        if (applicationService.checkAppUser(userId, appId)) {
            System.out.println("TEST applicationDetail--" + userId + "--" + appId);
            request.getSession().setAttribute("appId", appId);
            request.getSession().setAttribute("userId", userId);
            request.getRequestDispatcher("/WEB-INF/pages/views/applicationDetail.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("appId", null);
            response.sendRedirect(request.getContextPath() + "/?error=0");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

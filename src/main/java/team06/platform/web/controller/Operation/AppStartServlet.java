package team06.platform.web.controller.Operation;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.web.controller.ManagerServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppStartServlet extends HttpServlet {
    private ManagerServlet managerServlet = new ManagerServlet();
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result = managerServlet.start(
                request.getParameter("appId"),
                applicationService.getContextById(request.getParameter("appId")));

        String message = "<p>" + result + "</p>";
        request.setAttribute("message",message);
        request.getRequestDispatcher("/WEB-INF/pages/views/applicationDetail.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

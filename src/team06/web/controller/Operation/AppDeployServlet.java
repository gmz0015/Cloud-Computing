package team06.web.controller.Operation;

import team06.service.IApplicationService;
import team06.service.impl.ApplicationServiceImpl;
import team06.web.controller.ManagerServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppDeployServlet extends HttpServlet {
    private ManagerServlet managerServlet = new ManagerServlet();
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result = managerServlet.deploy(
                request.getParameter("appid"),
                applicationService.getWarById(request.getParameter("appid")),
                "/" + request.getSession().getAttribute("username") + generateid().substring(0, 4));

        String message = "<p>" + result + "</p>";
        request.setAttribute("message",message);
        request.getRequestDispatcher("/WEB-INF/pages/views/applicationDetail.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String generateid() {
        return String.valueOf(System.currentTimeMillis());
    }
}

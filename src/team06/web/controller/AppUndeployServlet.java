package team06.web.controller;

import team06.service.IApplicationService;
import team06.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AppUndeployServlet extends HttpServlet {
    private ManagerServlet managerServlet = new ManagerServlet();
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String result = managerServlet.undeploy(
                request.getParameter("appid"),
                applicationService.getContextById(request.getParameter("appid")));

        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

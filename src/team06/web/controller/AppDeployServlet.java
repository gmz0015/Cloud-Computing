package team06.web.controller;

import team06.service.IApplicationService;
import team06.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AppDeployServlet extends HttpServlet {
    private ManagerServlet managerServlet = new ManagerServlet();
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String result = managerServlet.deploy(
                request.getParameter("appid"),
                applicationService.getWarById(request.getParameter("appid")),
                "/" + request.getSession().getAttribute("username") + generateid().substring(0, 4));
//        request.getRequestDispatcher("/index.jsp").forward(request, response);

        PrintWriter out = response.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String generateid() {
        return String.valueOf(System.currentTimeMillis());
    }
}

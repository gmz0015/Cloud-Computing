package team06.platform.web.controller;

import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ApplicationDetailServlet extends HttpServlet {
    private IApplicationService appService = new ApplicationServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (true) {
            session.setAttribute("appid", request.getParameter("appid"));
            response.sendRedirect(request.getContextPath() + "/detail.jsp");
        } else {
            request.setAttribute("error", "0");
            System.out.println("Error 0");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
//        request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

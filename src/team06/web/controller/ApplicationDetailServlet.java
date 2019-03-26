package team06.web.controller;

import team06.domain.Application;
import team06.service.IApplicationService;
import team06.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ApplicationDetailServlet extends HttpServlet {
    private IApplicationService appService = new ApplicationServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (true) {
            session.setAttribute("sucess", "Successful");
            System.out.println("Successfule Redirect");
            response.sendRedirect(request.getContextPath()+"/detail.jsp");
        }else {
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

    public List<Application> getAllApps() {
        return appService.queryAllApps();
    }


    /**
     * Simulate authentication
     *
     * Remove Before Submit
     */
    public boolean validate(int ownerid) {
        if ((((int)(10 * Math.random())) % 2) == 1)
            return true;
        else
            return false;
    }
}

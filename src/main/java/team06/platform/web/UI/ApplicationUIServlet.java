package team06.platform.web.UI;

import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.DatabaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationUIServlet extends HttpServlet {
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check whether is developer
        if (request.getSession().getAttribute("userId") == null) {
            request.setAttribute("fromURI", request.getRequestURL());
            request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            String userId = request.getSession().getAttribute("userId").toString();
            String userName = request.getSession().getAttribute("userName").toString();
            String userRole = request.getSession().getAttribute("userRole").toString();

            if (userRole.equals("DEVELOPER")) {
                // access to application page
                request.getRequestDispatcher("/WEB-INF/pages/views/application.jsp").forward(request, response);
            } else {
                // no access
                response.sendRedirect(request.getContextPath() + "/console/?error=0");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("changePassword") != null) {
            request.setAttribute("message", databaseService.changePassword(request.getParameter("userName"), request.getParameter("password")));
            doGet(request, response);

        } else if (request.getParameter("executeSQL") != null) {
            String[] SQLs = request.getParameter("SQL").split(";");
            for (String SQL: SQLs) {
                databaseService.executeSQL(SQL);
            }
            doGet(request, response);
        } else {
            doGet(request, response);
        }
    }

}

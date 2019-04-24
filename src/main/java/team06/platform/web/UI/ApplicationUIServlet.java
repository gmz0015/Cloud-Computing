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
        if (request.getSession().getAttribute("userid") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
//            String userid = request.getSession().getAttribute("userid").toString();
//            String username = request.getSession().getAttribute("username").toString();
            String userrole = request.getSession().getAttribute("userrole").toString();

            if (userrole.equals("developer")) {
                // access to application page
                request.getRequestDispatcher("/WEB-INF/pages/views/application.jsp").forward(request, response);
            } else {
                // no access
                response.sendRedirect(request.getContextPath() + "/?error=0");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("changePassword") != null) {
            request.setAttribute("message", databaseService.changePassword(request.getParameter("username"), request.getParameter("password")));
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

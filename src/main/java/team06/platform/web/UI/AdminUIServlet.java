package team06.platform.web.UI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminUIServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check whether is developer
        if (true) {
            request.getRequestDispatcher("/WEB-INF/pages/views/admin.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/?error=0");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

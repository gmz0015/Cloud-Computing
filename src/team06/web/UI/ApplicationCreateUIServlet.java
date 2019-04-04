package team06.web.UI;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
public class ApplicationCreateUIServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check whether is developer
        if (true) {
            HttpSession session = request.getSession();
            request.getRequestDispatcher("/WEB-INF/pages/views/applicationCreate.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/?error=0");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

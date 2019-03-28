package team06.web.UI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ApplicationUIServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check whether it is developer
        if (true) {
            HttpSession session = request.getSession();
            session.setAttribute("userid", request.getParameter("userid"));
            System.out.println("userid is: " + request.getParameter("userid"));
            request.getRequestDispatcher("/WEB-INF/pages/views/application.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/?error=0");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

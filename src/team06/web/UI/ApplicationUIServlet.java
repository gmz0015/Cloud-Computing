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
        if (request.getParameter("Detail") == null){
            request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/pages/views/application.jsp").forward(request, response);
        }else if("Detail".equals(request.getParameter("Detail"))) {
            if (true) {
                HttpSession session = request.getSession();
                session.setAttribute("appid", request.getParameter("appid"));
                request.getRequestDispatcher("/WEB-INF/pages/views/application.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/?error=0");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

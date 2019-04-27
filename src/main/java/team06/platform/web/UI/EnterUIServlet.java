package team06.platform.web.UI;

import team06.platform.web.bean.CountBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterUIServlet extends HttpServlet {
    private CountBean countBean = new CountBean();
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.isUserInRole("USER") || request.isUserInRole("DEVELOPER") || request.isUserInRole("ADMIN")) {
            countBean.doCount("/app/" + request.getQueryString());
            response.sendRedirect("/app/" + request.getQueryString());
        }else {
            request.getRequestDispatcher(request.getContextPath() + "/errorPage/errorLogon.jsp").forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

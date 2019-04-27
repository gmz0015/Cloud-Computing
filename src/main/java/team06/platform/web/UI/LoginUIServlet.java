package team06.platform.web.UI;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUIServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getAttribute("fromURI") == null) {
            if (request.getRequestURI().equals("/login")) {
                request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
            }else if (request.getRequestURI().equals("/logout")) {
                request.getSession().setAttribute("userId", null);
                request.getSession().setAttribute("userName", null);
                request.getSession().setAttribute("userRole", null);
                request.logout();
                Cookie tokenCookie = new Cookie("token", "");
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(tokenCookie);
                response.sendRedirect("/");
            }else {
                System.out.println("Wrong Request LoginUIServlet");
                response.sendRedirect("/");
            }
        }else {
            if (request.getAttribute("fromURI").equals("/login")) {
                request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
            }else if (request.getAttribute("fromURI").equals("/logout")) {
                request.getSession().setAttribute("userId", null);
                request.getSession().setAttribute("userName", null);
                request.getSession().setAttribute("userRole", null);
                request.logout();
                Cookie tokenCookie = new Cookie("token", "");
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(tokenCookie);
                response.sendRedirect("/");
            }else {
                System.out.println("Wrong Request LoginUIServlet");
                response.sendRedirect("/");
            }
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

package team06.platform.web.controller;

import team06.platform.domain.User;
import team06.platform.service.IUserService;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String Referer;
        if (request.getParameter("Referer").equals("null")) {
            Referer = "/";
        }else {
            Referer = request.getParameter("Referer");
        }

        //get user name and password
        String username = request.getParameter("username");
        String password = request.getParameter("psw");

        //verify the username and password
        User webuser = userService.login(username, password);

        if(webuser == null) {
            //response.sendRedirect("/javaWEB/html/cloud.jsp");
            //pw.println("<script language = 'javascript'>");
            pw.println("<script>alert('username or password is incorrect!');window.location.href='/login'</script>");
            return;
        }

        //get session object
        HttpSession session = request.getSession();
        request.getSession().setAttribute("userId", webuser.getUserId().toString());
        request.getSession().setAttribute("userName", webuser.getUserName());
        request.getSession().setAttribute("userRole", webuser.getUserRole());

        Cookie idCookie = new Cookie("userId", webuser.getUserId().toString());
        idCookie.setMaxAge(1*24*60*60);
        idCookie.setPath("/");
        Cookie nameCookie = new Cookie("userName", webuser.getUserName());
        nameCookie.setMaxAge(1*24*60*60);
        nameCookie.setPath("/");
        Cookie roleCookie = new Cookie("userRole", webuser.getUserRole());
        roleCookie.setMaxAge(1*24*60*60);
        roleCookie.setPath("/");
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");

        response.addCookie(cookie);
        response.addCookie(idCookie);
        response.addCookie(nameCookie);
        response.addCookie(roleCookie);

        request.login(webuser.getUserName(), webuser.getPassword());



        response.sendRedirect(Referer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

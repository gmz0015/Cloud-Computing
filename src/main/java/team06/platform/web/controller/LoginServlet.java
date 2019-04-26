package team06.platform.web.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import team06.platform.domain.User;
import team06.platform.service.IUserService;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set Token
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        Map<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");

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
        request.getSession().setAttribute("userId", webuser.getUserId().toString());
        request.getSession().setAttribute("userName", webuser.getUserName());
        request.getSession().setAttribute("userRole", webuser.getUserRole());
        request.getSession().setAttribute("avatar", webuser.getAvatar());

        String token = JWT.create()
                .withHeader(header)
                .withClaim("userId", webuser.getUserId().toString())
                .withClaim("userName", webuser.getUserName())
                .withClaim("userRole", webuser.getUserRole())
                .sign(algorithm);
        Cookie tokenCookie = new Cookie("token", token);
        tokenCookie.setMaxAge(1*24*60*60);
        tokenCookie.setPath("/");

        response.addCookie(tokenCookie);

        request.login(webuser.getUserName(), webuser.getPassword());

        response.sendRedirect(Referer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

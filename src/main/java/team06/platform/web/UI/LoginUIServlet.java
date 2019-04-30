package team06.platform.web.UI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IUserService;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUIServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = null;
        String userId = null;
        if (request.getAttribute("fromURI") == null) {
            if (request.getRequestURI().equals("/login")) {
                request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
            }else if (request.getRequestURI().equals("/logout")) {
                token = request.getSession().getAttribute("token").toString();

                if (token != null) {
                    Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT jwt = verifier.verify(request.getSession().getAttribute("token").toString());
                    userId = jwt.getClaim("userId").asString();
                    userService.logout(Long.valueOf(userId));
                }else {
                    Cookie tokenCookie = new Cookie("token", null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(tokenCookie);
                    Cookie userIdCookie = new Cookie("userId",null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(userIdCookie);
                    Cookie userNameCookie = new Cookie("userName", null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(userNameCookie);
                    Cookie userRoleCookie = new Cookie("userRole", null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(userRoleCookie);
                    response.sendRedirect("/");
                }
                Cookie tokenCookie = new Cookie("token", null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(tokenCookie);
                Cookie userIdCookie = new Cookie("userId",null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(userIdCookie);
                Cookie userNameCookie = new Cookie("userName", null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(userNameCookie);
                Cookie userRoleCookie = new Cookie("userRole", null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(userRoleCookie);
                request.getSession().setAttribute("userId", null);
                request.getSession().setAttribute("userName", null);
                request.getSession().setAttribute("userRole", null);
                request.logout();
                request.getSession().setAttribute("token", null);
                request.getSession().invalidate();
                response.sendRedirect("/");
            }else {
                System.out.println("Wrong Request LoginUIServlet");
                response.sendRedirect("/");
            }
        }else {
            if (request.getAttribute("fromURI").equals("/login")) {
                request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
            }else if (request.getAttribute("fromURI").equals("/logout")) {
                token = request.getSession().getAttribute("token").toString();

                if (token != null) {
                    Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT jwt = verifier.verify(request.getSession().getAttribute("token").toString());
                    userId = jwt.getClaim("userId").asString();
                    userService.logout(Long.valueOf(userId));
                }else {
                    Cookie tokenCookie = new Cookie("token", null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(tokenCookie);
                    Cookie userIdCookie = new Cookie("userId",null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(userIdCookie);
                    Cookie userNameCookie = new Cookie("userName", null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(userNameCookie);
                    Cookie userRoleCookie = new Cookie("userRole", null);
                    tokenCookie.setMaxAge(0);
                    tokenCookie.setPath("/");
                    response.addCookie(userRoleCookie);
                    response.sendRedirect("/");
                }
                Cookie tokenCookie = new Cookie("token", null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(tokenCookie);
                Cookie userIdCookie = new Cookie("userId",null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(userIdCookie);
                Cookie userNameCookie = new Cookie("userName", null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(userNameCookie);
                Cookie userRoleCookie = new Cookie("userRole", null);
                tokenCookie.setMaxAge(0);
                tokenCookie.setPath("/");
                response.addCookie(userRoleCookie);
                request.getSession().setAttribute("userId", null);
                request.getSession().setAttribute("userName", null);
                request.getSession().setAttribute("userRole", null);
                request.getSession().setAttribute("token", null);
                request.logout();
                response.sendRedirect("/");
            }else {
                System.out.println("Wrong Request LoginUIServlet");
                request.getSession().invalidate();
                response.sendRedirect("/");
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

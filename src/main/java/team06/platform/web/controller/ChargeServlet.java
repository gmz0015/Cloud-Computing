package team06.platform.web.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChargeServlet extends HttpServlet {
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/console");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer type = Integer.valueOf(request.getParameter("type"));
        String userId = null;
        String userName = null;
        String referer = request.getRequestURI();

        String token = null;

        if (request.getSession().getAttribute("token") != null) {
            token = request.getSession().getAttribute("token").toString();
            if (token != null) {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                userId = jwt.getClaim("userId").asString();
                userName = jwt.getClaim("userName").asString();

                // Check whether is developer
                if (userId == null || userId.equals("")) {
                    response.sendRedirect(request.getContextPath() + "/console?error=401.1");
                } else {
                    // change to Entrance Mode
                    if (type == 0) {
                        if (applicationService.checkAppUser(userId, request.getSession().getAttribute("appId").toString())) {
                            applicationService.setChargeByAppId(request.getSession().getAttribute("appId").toString(), 0);
                            response.getWriter().println("<script>alert('Change to Entrance Mode Successful. ');window.location.href='/application'</script>");
                        }else {
                            response.getWriter().println("<script>alert('Change to Entrance Mode Failed. You can try it again.');window.location.href='/logout'</script>");
                        }
                    }

                    // change to Both Mode
                    if (type == 1) {
                        if (applicationService.checkAppUser(userId, request.getSession().getAttribute("appId").toString())) {
                            applicationService.setChargeByAppId(request.getSession().getAttribute("appId").toString(), 1);
                            response.getWriter().println("<script>alert('Change to Entrance + In-app Mode Successful. ');window.location.href='/application'</script>");
                        }else {
                            response.getWriter().println("<script>alert('Change to Entrance + In-app Mode Failed. You can try it again.');window.location.href='/logout'</script>");
                        }
                    }

                    // change to In-App Mode
                    if (type == 2) {
                        if (applicationService.checkAppUser(userId, request.getSession().getAttribute("appId").toString())) {
                            applicationService.setChargeByAppId(request.getSession().getAttribute("appId").toString(), 2);
                            response.getWriter().println("<script>alert('Change to In-app Mode Successful. ');window.location.href='/application'</script>");
                        }else {
                            response.getWriter().println("<script>alert('Change to In-app Mode Failed. You can try it again.');window.location.href='/logout'</script>");
                        }
                    }
                }
            }else {
                // no access
                response.sendRedirect(request.getContextPath() + "/console?error=401.1");
            }
        }else {
            // no access
            response.sendRedirect(request.getContextPath() + "/console?error=401.1");
        }
    }
}

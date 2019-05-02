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

public class RatingServlet extends HttpServlet {
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer rating = Integer.valueOf(request.getParameter("level"));
        String appId = request.getParameter("appId");
        String userId = null;
        String userName = null;
        String referer = request.getHeader("Referer");

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
                    response.sendRedirect(request.getContextPath() + "/?error=401.1");
                } else {
                    applicationService.setRatingByAppId(appId, rating);
                    response.getWriter().println("<script>alert('Rating Successful. Thank you for your rating');window.location.href='" + referer + "'</script>");
                }
            }else {
                // no access
                response.sendRedirect(request.getContextPath() + "/?error=401.1");
            }
        }else {
            // no access
            response.sendRedirect(request.getContextPath() + "/?error=401.1");
        }
    }
}

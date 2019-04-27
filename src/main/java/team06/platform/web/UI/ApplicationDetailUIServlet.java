package team06.platform.web.UI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationDetailUIServlet extends HttpServlet {
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String appId = request.getParameter("appId");
        String userId;
        String userName = null;
        String userRole = null;
        String token = null;

        Cookie[] cs = request.getCookies();
        if(cs != null) {
            for(Cookie c : cs) {
                if(c.getName().equals("token")) {
                    token = c.getValue();
                }
            }
        }

        if (token != null) {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            userId = jwt.getClaim("userId").asString();
            userName = jwt.getClaim("userName").asString();
            userRole = jwt.getClaim("userRole").asString();

            // Check whether is developer
            if (userId == null || userId.equals("")) {
                request.setAttribute("fromURI", request.getRequestURL());
                request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
            } else {
                if (userRole.equals("DEVELOPER") || userRole.equals("ADMIN")) {
                    if (applicationService.checkAppUser(userId, appId)) {
                        request.getSession().setAttribute("appId", appId);
                        request.getRequestDispatcher("/WEB-INF/pages/views/applicationDetail.jsp").forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "?error=401.4");
                    }
                } else {
                    // no access
                    response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                }
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

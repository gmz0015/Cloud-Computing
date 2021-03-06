package team06.platform.web.controller.Operation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.web.controller.ManagerServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppStopServlet extends HttpServlet {
    private ManagerServlet managerServlet = new ManagerServlet();
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = null;
        String userId = null;
        String result = null;

        if (request.getSession().getAttribute("token") != null) {
            token = request.getSession().getAttribute("token").toString();
            if (token != null) {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                userId = jwt.getClaim("userId").asString();

                if (applicationService.checkAppUser(userId, request.getParameter("appId"))) {
                    result = managerServlet.stop(
                            request.getParameter("appId"),
                            applicationService.getContextById(request.getParameter("appId")));
                }else {
                    result = "Delete Failed - You have no access to stop the application";
                }

                String message = "<p>" + result + "</p>";
                request.setAttribute("message",message);
                request.getRequestDispatcher("/WEB-INF/pages/views/applicationDetail.jsp").forward(request, response);
            } else {
                // no access
                response.sendRedirect(request.getContextPath() + "/?error=401.1");
            }
        } else {
            // no access
            response.sendRedirect(request.getContextPath() + "/?error=401.1");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

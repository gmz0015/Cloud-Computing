package team06.platform.web.UI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.DatabaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationUIServlet extends HttpServlet {
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                    // access to application page
                    request.getRequestDispatcher("/WEB-INF/pages/views/application.jsp").forward(request, response);
                } else {
                    // no access
                    response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                }
            }
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("changePassword") != null) {
            request.setAttribute("message", databaseService.changePassword(request.getParameter("userName"), request.getParameter("password")));
            doGet(request, response);

        } else if (request.getParameter("executeSQL") != null) {
            String[] SQLs = request.getParameter("SQL").split(";");
            for (String SQL: SQLs) {
                databaseService.executeSQL(SQL);
            }
            doGet(request, response);
        } else {
            doGet(request, response);
        }
    }

}

package team06.platform.web.UI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.DatabaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreferenceUIServlet extends HttpServlet {

    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = null;
        String token = null;

        if (request.getSession().getAttribute("token") != null) {
            token = request.getSession().getAttribute("token").toString();
            if (token != null) {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                userId = jwt.getClaim("userId").asString();

                // Check whether is developer
                if (userId == null || userId.equals("")) {
                    request.setAttribute("fromURI", request.getRequestURL());
                    request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
                } else {
                    request.getRequestDispatcher("/WEB-INF/pages/views/preference.jsp").forward(request, response);
                }
            } else {
                // no access
                response.sendRedirect(request.getContextPath() + "/console?error=401.1");
            }
        } else {
            // no access
            response.sendRedirect(request.getContextPath() + "/console?error=401.1");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

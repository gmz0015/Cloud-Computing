package team06.platform.web.UI;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Application;
import team06.platform.domain.Charge;
import team06.platform.service.IAccountService;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.AccountServiceImpl;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.web.bean.CountBean;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnterUIServlet extends HttpServlet {
    private CountBean countBean = new CountBean();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IAccountService accountService = new AccountServiceImpl();
    private IApplicationService applicationService = new ApplicationServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String token = null;
        String userId = null;
        String userName = null;
        String userRole = null;
        String userAvatar = null;
        Application application = null;
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        Map<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");


        if (request.getSession().getAttribute("token") == null) {
            request.getRequestDispatcher(request.getContextPath() + "/errorPage/errorLogon.jsp").forward(request, response);
        }else {
            token = request.getSession().getAttribute("token").toString();
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            userId = jwt.getClaim("userId").asString();
            userName = jwt.getClaim("userName").asString();
            userRole = jwt.getClaim("userRole").asString();
            userAvatar = jwt.getClaim("userAvatar").asString();

            application = applicationService.getAppByContext(request.getQueryString());

            Boolean result = accountService.isCharge(new Charge(Long.valueOf(userId), Long.valueOf(application.getAppId())));
            if (!result) {
                accountService.charge(Long.valueOf(userId), Long.valueOf(application.getAppId()), 5.0);
            }
            countBean.doCount(request.getQueryString());

            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withClaim("userName", userName)
                    .withClaim("userRole", userRole)
                    .withClaim("userAvatar", userAvatar)
                    .sign(algorithm);
            request.getSession().setAttribute("token", token);

            String appUUID = JWT.create()
                    .withHeader(header)
                    .withClaim("appId", application.getAppId())
                    .sign(algorithm);
            Cookie UUIDCookie = new Cookie("appUUID", appUUID);
            UUIDCookie.setMaxAge(1*24*60*60);
            UUIDCookie.setPath("/");
            response.addCookie(UUIDCookie);

            response.sendRedirect("/app/" + request.getQueryString());
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

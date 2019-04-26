package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Application;
import team06.platform.service.IApplicationService;
import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.service.impl.DatabaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class ApplicationDetailBean implements Serializable {
    private String userId;
    private String appId;
    private Application appInfo;
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    private IApplicationService applicationService = new ApplicationServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public ApplicationDetailBean() {}

    public Application doQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (applicationService.checkAppUser(userId, appId)) {
            appInfo = applicationService.getAppByAppId(appId);
        }else {
            response.sendRedirect(request.getContextPath() + "/console/?error=401.4");
        }
        return appInfo;
    }

    public void getInfo(HttpServletRequest request) {
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
            this.userId = jwt.getClaim("userId").asString();
        }
    }

    public Application getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(Application appInfo) {
        this.appInfo = appInfo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

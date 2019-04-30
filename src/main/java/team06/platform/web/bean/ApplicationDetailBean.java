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
    private String appUUID;
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    private IApplicationService applicationService = new ApplicationServiceImpl();

    public ApplicationDetailBean() {}

    public Application doQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (applicationService.checkAppUser(this.userId, this.appId)) {
            appInfo = applicationService.getAppByAppId(this.appId);
            appUUID = applicationService.getAppUUID(this.appId);
            System.out.println("TEST queryApp:" + appInfo.getOwnerName());
        }else {
            response.sendRedirect(request.getContextPath() + "/console?error=401.4");
        }
        return appInfo;
    }

    public void getInfo(HttpServletRequest request) {
        String token = null;

        if (request.getSession().getAttribute("token") != null) {
            token = request.getSession().getAttribute("token").toString();
            if (token != null) {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                this.userId = jwt.getClaim("userId").asString();
            }else {
                this.userId = null;
            }
        }else {
            this.userId = null;
        }
    }

    /* Setter and Getter */
    public String getAppUUID() {
        return appUUID;
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

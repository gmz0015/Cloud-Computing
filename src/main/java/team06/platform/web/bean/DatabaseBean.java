package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.dao.IDatabaseDao;
import team06.platform.dao.impl.DatabaseDaoImpl;
import team06.platform.domain.Database;
import team06.platform.service.IApplicationService;
import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.service.impl.DatabaseServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DatabaseBean {
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private String userId;
    private String appId;
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

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
            System.out.println("TEST database userID:" + userId);
        }
    }

    public Database queryDBbyId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (applicationService.checkAppUser(userId, appId)) {
            return databaseService.queryDBbyid(this.userId);
        }else {
            response.sendRedirect(request.getContextPath() + "/console/?error=401.4");
            return null;
        }
    }

    public String queryUsage(String databaseName) {
        return databaseDao.queryDBUsage(databaseName);
    }

    public List<Map<String, String>> queryTableUsage(String databaseName) {
        return databaseDao.queryDBTableUsage(databaseName);
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

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
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DatabaseBean{
    private IDatabaseDao databaseDao = new DatabaseDaoImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private String userId;
    private String appId = null;
    private String userName;
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public void getInfo(HttpServletRequest request) {
        String token = null;

        if (request.getSession().getAttribute("token") != null) {
            token = request.getSession().getAttribute("token").toString();
            if (token != null) {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                userId = jwt.getClaim("userId").asString();
                userName = jwt.getClaim("userName").asString();
            }else {
                userId = null;
                userName = null;
            }
        }else {
            userId = null;
            userName = null;
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Database queryDBbyId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return databaseService.queryDBbyid(this.userId, this.userName);
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

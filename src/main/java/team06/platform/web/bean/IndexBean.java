package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Account;
import team06.platform.domain.Application;
import team06.platform.service.*;
import team06.platform.service.impl.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

public class IndexBean {
    private String userId;
    private String userName;
    private List<String> appsId;
    private List<Application> appInfo;
    private Integer balance;
    private String avatar;
    private String userRole;
    private String usage;
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IAccountService accountService = new AccountServiceImpl();
    private IDatabaseService databaseService  = new DatabaseServiceImpl();

    public IndexBean() {
        IApplicationService appService = new ApplicationServiceImpl();
        appInfo = appService.getAllApps();
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
                this.userName = jwt.getClaim("userName").asString();
                this.userRole = jwt.getClaim("userRole").asString();
                this.avatar = jwt.getClaim("userAvatar").asString();
                this.balance = accountService.getBalance(Long.valueOf(userId));
            }else {
                this.userId = null;
                this.userName = null;
                this.userRole = null;
                this.avatar = null;
                this.balance = 0;
            }
        }else {
            this.userId = null;
            this.userName = null;
            this.userRole = null;
            this.avatar = null;
            this.balance = 0;
        }
    }

    public Integer getBalance() {
        return balance;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<Application> getAllApps(){
        return appInfo;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getAppsId() {
        return appsId;
    }

    public void setAppsId(List<String> appsId) {
        this.appsId = appsId;
    }

    public List<Application> getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(List<Application> appInfo) {
        this.appInfo = appInfo;
    }

    public String getUserRole() {
        return userRole;
    }
}

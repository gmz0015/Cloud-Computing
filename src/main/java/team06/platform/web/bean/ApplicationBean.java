package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Application;
import team06.platform.domain.Transaction;
import team06.platform.service.IAccountService;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.AccountServiceImpl;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationBean{
    private String userId;
    private String appId;
    private List<Application> appInfo;
    private String appUUID;
    private Integer total = 0;
    private Integer running = 0;
    private Integer stop = 0;
    private Integer undeploy = 0;
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    private IApplicationService applicationService = new ApplicationServiceImpl();
    private IAccountService accountService = new AccountServiceImpl();

    public ApplicationBean(){
        appInfo = new ArrayList<>();
    }

    /**
     * Invoke service to query Database and retrieve applications data
     */
    public void doQuery(HttpServletRequest request, HttpServletResponse response) throws IOException{
        appInfo = applicationService.getAppByUserId(userId);
//        appUUID = applicationService.getAppUUID(this.appInfo);
        count();
    }

    public void getInfo(HttpServletRequest request) {
        String token = null;

        if (request.getSession().getAttribute("token") != null) {
            token = request.getSession().getAttribute("token").toString();
            if (token != null) {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT jwt = verifier.verify(token);
                userId = jwt.getClaim("userId").asString();
            }else {
                userId = null;
            }
        }else {
            userId = null;
        }
    }

    private void count(){
        for (Application application: appInfo) {
            total += 1;
            if (application.getStatus() == 0)
                undeploy += 1;
            else if (application.getStatus() == 1)
                stop += 1;
            else if (application.getStatus() == 2)
                running += 1;
        }
    }

    public List<Application> getAppInfo() {
        return appInfo;
    }

    public List<Application> getAllLiveAppInfo() {
        return applicationService.getAllLiveAppInfo();
    }

    public Integer getBalance() {
        return accountService.getBalance(Long.valueOf(this.userId));
    }

    public List<Transaction> getAppTransaction() {
        return accountService.getAppTransaction(Long.valueOf(this.appId));
    }

    /* Setter and Getter */

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        System.out.printf("[%-23s] ApplicationBean setUserId:%s\n", new Timestamp(new Date().getTime()), userId);
        this.userId = userId;
    }

    public String getAppUUID() {
        return appUUID;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRunning() {
        return running;
    }

    public void setRunning(Integer running) {
        this.running = running;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public Integer getUndeploy() {
        return undeploy;
    }

    public void setUndeploy(Integer undeploy) {
        this.undeploy = undeploy;
    }

    public void setAppInfo(List<Application> appInfo) {
        this.appInfo = appInfo;
    }
}

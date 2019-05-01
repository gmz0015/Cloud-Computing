package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Database;
import team06.platform.service.IDatabaseService;
import team06.platform.service.IManagerService;
import team06.platform.service.impl.DatabaseServiceImpl;
import team06.platform.service.impl.ManagerService;
import team06.platform.web.controller.ManagerServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class AppCreateBean extends HttpServlet  {
    private int uploadStatus = 0;
    private int deployStatus = 0;
    private int startupStatus = 0;
    private final String SAVE_DIR = "uploadedFiles";
    private int nextStep = 0;
    private IDatabaseService databaseService = new DatabaseServiceImpl();
    private String userId;
    private String userName;
    private ManagerServlet managerServlet = new ManagerServlet();
    private IManagerService managerService = new ManagerService();

    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

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
            }else {
                this.userId = null;
                this.userName = null;
            }
        }else {
            this.userId = null;
            this.userName = null;
        }
    }


    public Database queryDBbyid() {
        nextStep = 1;
        return databaseService.queryDBbyid(this.userId, this.userName);
    }

    public void doUpload(HttpServletRequest request){

    }


    /* Getter and Setter */
    public int getNextStep() { return nextStep; }

    public int getStartupStatus() { return startupStatus; }

    public int getDeployStatus() { return deployStatus; }

    public int getUploadStatus() { return uploadStatus; }
}

package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.User;
import team06.platform.service.IUserService;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class PreferenceBean  {
    private String userId;
    private User user;
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";
    private IUserService userService = new UserServiceImpl();


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

        this.user = userService.getUserInfo(this.userId);
    }

    public String getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }
}

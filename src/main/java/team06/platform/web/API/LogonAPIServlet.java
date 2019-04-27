package team06.platform.web.API;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IUserService;
import team06.platform.service.impl.UserServiceImpl;

import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;

@Path("/logon")
public class LogonAPIServlet {
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    @GET
    @Produces("application/json")
    @Path("userinfo")
    public Map<String, String> getBalance(@CookieParam("token") String token){
        Map<String, String> userInfo = new HashMap<>();
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String userId = jwt.getClaim("userId").asString();
        String userName = jwt.getClaim("userName").asString();
        String userRole = jwt.getClaim("userRole").asString();


        if (userId == null || userId.equals("")) {
            userInfo.put("userId", "Failed Query");
            return userInfo;
        }else {
            userInfo.put("userId", userId);
            userInfo.put("userName", userName);
            userInfo.put("userRole", userRole);
            return userInfo;
        }
    }
}

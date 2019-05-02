package team06.platform.web.API;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IAccountService;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.AccountServiceImpl;
import team06.platform.service.impl.ApplicationServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/account")
public class AccountAPIServlet {
    private IAccountService accountService = new AccountServiceImpl();
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("balance/{userId}")
    public String getBalance(@PathParam("userId") Long userId){
        if (userId == null) {
            return "fail";
        }else {
            Integer balance = accountService.getBalance(userId);
            if (balance == null) {
                return "fail";
            }else {
                return balance.toString();
            }
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("transfer")
    public String transfer(@FormParam("fromUserId") Long fromUserId, @FormParam("toUserId") Long toUserId, @FormParam("appUUID") String appUUID, @FormParam("amount") Integer amount){
        if (fromUserId == null || toUserId == null || appUUID == null || amount == null) {
            return "fail";
        }else {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(appUUID);
            String appId = jwt.getClaim("appId").asString();
            if (appId == null) {
                return "fail";
            }else {
                if (accountService.transfer(fromUserId, toUserId, "Application Consumption", Long.valueOf(appId), amount)) {
                    return "success";
                }else {
                    return "fail";
                }
            }
        }
    }
}

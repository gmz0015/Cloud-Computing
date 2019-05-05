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
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("balance/{userId}")
    public String getBalance(@PathParam("userId") Long userId){
        if (userId == null) {
            return "fail";
        }else {
            Double balance = accountService.getBalance(userId);
            if (balance == null) {
                return "fail";
            }else {
                return balance.toString();
            }
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("transfer2")
    public String transfe2(@FormParam("fromUserId") Long fromUserId, @FormParam("toUserId") Long toUserId, @FormParam("appUUID") String appUUID, @FormParam("devAmount") Double devAmount, @FormParam("amount") Double amount){
        if (fromUserId == null || toUserId == null || appUUID == null || devAmount == null || amount == null) {
            return "fail";
        }else {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            JWTVerifier verifier = JWT.require(algorithm).build();
            try {
                DecodedJWT jwt = verifier.verify(appUUID);
                String appId = jwt.getClaim("appId").asString();
                if (appId == null) {
                    return "fail";
                }else {
                    if (accountService.transfer2(fromUserId, toUserId, "In-App - Mode 2", Long.valueOf(appId), devAmount, amount)) {
                        return "success";
                    }else {
                        return "fail";
                    }
                }
            }catch (Exception e) {
                return "fail";
            }
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("transfer3")
    public String transfer3(@FormParam("fromUserId") Long fromUserId, @FormParam("toUserId") Long toUserId, @FormParam("appUUID") String appUUID, @FormParam("devAmount") Double devAmount, @FormParam("amount") Double amount){
        if (fromUserId == null || toUserId == null || appUUID == null || devAmount == null || amount == null) {
            return "fail";
        }else {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            JWTVerifier verifier = JWT.require(algorithm).build();
            try {
                DecodedJWT jwt = verifier.verify(appUUID);
                String appId = jwt.getClaim("appId").asString();
                if (appId == null) {
                    return "fail";
                }else {
                    if (accountService.transfer3(fromUserId, toUserId, "In-App - Mode 3", Long.valueOf(appId), devAmount, amount)) {
                        return "success";
                    }else {
                        return "fail";
                    }
                }
            }catch (Exception e) {
                return "fail";
            }
        }
    }
}

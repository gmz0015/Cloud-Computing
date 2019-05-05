package team06.platform.web.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.domain.Transaction;
import team06.platform.service.IAccountService;
import team06.platform.service.impl.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AccountBean  {
    private IAccountService accountService = new AccountServiceImpl();
    private String userId;
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
            }else {
                this.userId = null;
            }
        }else {
            this.userId = null;
        }
    }

    public Double getBalance() {
        return accountService.getBalance(Long.valueOf(this.userId));
    }

    public List<Transaction> getTransaction() { return accountService.getTransaction(Long.valueOf(this.userId)); }
}

package team06.platform.web.API;

import team06.platform.service.IAccountService;
import team06.platform.service.impl.AccountServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountAPIServlet {
    private IAccountService accountService = new AccountServiceImpl();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("balance/{userId}")
    public String getBalance(@PathParam("userId") Long userId){
        System.out.println("userid is:" + userId);
        Integer balance = accountService.getBalance(userId);
        if (balance == null) {
            return "Failed Query";
        }else {
            return balance.toString();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("transfer")
    public String transfer(@FormParam("fromUserId") Long fromUserId, @FormParam("toUserId") Long toUserId, @FormParam("appId") Long appId, @FormParam("amount") Integer amount){
        Boolean result = accountService.transfer(fromUserId, toUserId, "Application Consumption", appId, amount);
        if (result) {
            return "Successful Transfer";
        }else {
            return "Failed Transfer";
        }
    }
}

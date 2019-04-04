package team06.test.web.API;

import team06.test.domain.User;
import team06.test.service.IUserService;
import team06.test.service.impl.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class testAPIServlet {
    private IUserService userService = new UserServiceImpl();

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("login")
    public String sayHello(@FormParam("username") String username, @FormParam("password") String password){
        User user = userService.getUserByUsername(username);
        if (user == null) {
            // The username is not right
            return "0";
        }else if (user.getPassword().equals(password)) {
            return "userid=" + user.getUserid() + "&username=" + user.getName();
        }else {
            // The input password is not right
            return "1";
        }
    }

    @POST
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello,I am xml!" + "</hello>";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello,I am html!" + "</body></h1>" + "</html> ";
    }
}

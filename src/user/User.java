package user;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class User extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserQuery userQuery = new UserQuery();
        JSONObject json = new JSONObject();

        //Set response type
        response.setContentType("text/javascript");

        String mode = request.getParameter("type");

        switch (mode){
            case "find":
                String userid = request.getParameter("userid");
                json = userQuery.find(userid);
                response.getWriter().write(json.toString());
                break;
            case "database":
                response.sendRedirect(request.getContextPath()+"/account.jsp");
                break;
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
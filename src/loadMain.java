import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class loadMain extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, this message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Set response type
        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();

        String mode = request.getParameter("type");
        System.out.println(mode);

        switch (mode){
            case "home":
                response.sendRedirect(request.getContextPath()+"/index.jsp");
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
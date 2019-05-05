package team06.platform.web.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import team06.platform.service.IApplicationService;
import team06.platform.service.IUserService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10, // 10MB
        maxRequestSize=1024*1024*50) // 50MB
public class ChangeWarServlet extends HttpServlet {
    private IApplicationService applicationService = new ApplicationServiceImpl();
    private IUserService userService = new UserServiceImpl();
    private ManagerServlet managerServlet = new ManagerServlet();
    private final String SAVE_DIR = "uploadedFiles";
    private static final String TOKEN_SECRET = "fd8780zdufb7f5bnz456fd";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("/");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String userId = null;
        String userName = null;
        String referer = request.getRequestURI();

        String token = null;

        if (type != null) {
            if (request.getSession().getAttribute("token") != null) {
                token = request.getSession().getAttribute("token").toString();
                if (token != null) {
                    Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT jwt = verifier.verify(token);
                    userId = jwt.getClaim("userId").asString();
                    userName = jwt.getClaim("userName").asString();

                    // Check whether is developer
                    if (userId == null || userId.equals("")) {
                        response.sendRedirect(request.getContextPath() + "/console?error=401.1");
                    } else {
                        // Change War File
                        if (type.equals("warFile")) {
                            String appPath = request.getServletContext().getRealPath("");
                            if (request.getContentType() != null) {
                                System.out.println("request.getContentType() != null");
                                if (request.getContentType().split(";")[0].equals("multipart/form-data")) {
                                    for (Part part : request.getParts()) {
                                        if (part.getName().equals("file")) {
                                            try {
                                                // Invoke upload process
                                                String savePath = managerServlet.upload(appPath + SAVE_DIR, part);
                                                if (savePath.equals("Failed Upload: Wrong File Type")) {
                                                    response.getWriter().println("<script>alert('Sorry, Change Failed. Wrong File Type. Please Try Again');window.location.href='/application'</script>");
                                                }
                                                applicationService.setWarById(request.getSession().getAttribute("appId").toString(), savePath);

                                                // Delete Previous War File
                                                String fileName = applicationService.getWarById(request.getSession().getAttribute("appId").toString());
                                                File file = new File(fileName);
                                                if (file.exists() && file.isFile()) {
                                                    if (file.delete()) {
                                                        response.getWriter().println("<script>alert('War File Change Successful.');window.location.href='/application'</script>");
                                                    } else {
                                                        response.getWriter().println("<script>alert('Sorry, Delete Previous File Failed. Please Contact Admin to Delete Previous File');window.location.href='/application'</script>");
                                                    }
                                                } else {
                                                    response.getWriter().println("<script>alert('War File Change Successful. No Previous War File need to be Deleted');window.location.href='/application'</script>");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("[team06.platform.web.controller.CreateNewAppServlet.doGet]: " + e);
                                                // Upload Failed, dispatch back
                                                response.getWriter().println("<script>alert('Sorry, Change Failed. Please Try Again');window.location.href='/application'</script>");
                                            }
                                        }
                                    }
                                    response.getWriter().println("<script>alert('Sorry, Change Failed. Please Try Again');window.location.href='/logout'</script>");
                                }else {
                                    response.getWriter().println("<script>alert('Sorry, Change Failed. Please Try Again');window.location.href='/logout'</script>");
                                }
                            }else {
                                response.getWriter().println("<script>alert('Sorry, Change Failed. Please Try Again');window.location.href='/logout'</script>");
                            }
                        }
                    }
                } else {
                    // no access
                    response.sendRedirect(request.getContextPath() + "/console?error=401.1");
                }
            } else {
                // no access
                response.sendRedirect(request.getContextPath() + "/console?error=401.1");
            }
        } else {
            // no access
            response.sendRedirect(request.getContextPath() + "/console?error=401.1");
        }
    }
}

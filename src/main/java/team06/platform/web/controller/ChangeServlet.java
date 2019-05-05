package team06.platform.web.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import team06.platform.domain.User;
import team06.platform.service.IApplicationService;
import team06.platform.service.IUserService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class ChangeServlet extends HttpServlet {
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
                        // Change Password
                        if (type.equals("password")) {
                            //verify the username and password
                            User webuser = userService.login(userName, request.getParameter("psw0"));
                            if(webuser == null) {
                                response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                            }else {
                                if (request.getParameter("psw1").equals(request.getParameter("psw2"))) {
                                    if (userService.changePassword(userId, request.getParameter("psw1"))) {
                                        response.getWriter().println("<script>alert('Password Change Successful. You need login again.');window.location.href='/logout'</script>");
                                    }else {
                                        response.getWriter().println("<script>alert('Password Change Failed. You can try it again.');window.location.href='/logout'</script>");
                                    }
                                }else {
                                    response.getWriter().println("<script>alert('The Tow passwords you typed do not match');window.location.href='/console'</script>");
                                }
                            }
                        }

                        // Change Email
                        if (type.equals("email")) {
                            //verify the username and password
                            User webuser = userService.login(userName, request.getParameter("psw"));
                            if(webuser == null) {
                                response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                            }else {
                                if (userService.changeEmail(userId, request.getParameter("email"))) {
                                    response.getWriter().println("<script>alert('Email Change Successful.');window.location.href='/console'</script>");
                                }else {
                                    response.getWriter().println("<script>alert('Email Change Failed. You can try it again.');window.location.href='/logout'</script>");
                                }
                            }
                        }

                        // Change Name
                        if (type.equals("name")) {
                            //verify the username and password
                            User webuser = userService.login(userName, request.getParameter("psw"));
                            if(webuser == null) {
                                response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                            }else {
                                if (applicationService.checkAppUser(userId, request.getSession().getAttribute("appId").toString())) {
                                    if (applicationService.changeName(request.getSession().getAttribute("appId").toString(), request.getParameter("name"))) {
                                        response.getWriter().println("<script>alert('Name Change Successful.');window.location.href='/application'</script>");
                                    }else {
                                        response.getWriter().println("<script>alert('Name Change Failed. You can try it again.');window.location.href='/logout'</script>");
                                    }
                                }else {
                                    // no access
                                    response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                                }

                            }
                        }

                        // Change Description
                        if (type.equals("description")) {
                            //verify the username and password
                            User webuser = userService.login(userName, request.getParameter("psw"));
                            if(webuser == null) {
                                response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                            }else {
                                if (applicationService.checkAppUser(userId, request.getSession().getAttribute("appId").toString())) {
                                    if (applicationService.changeDescription(request.getSession().getAttribute("appId").toString(), request.getParameter("description"))) {
                                        response.getWriter().println("<script>alert('Description Change Successful. ');window.location.href='/application'</script>");
                                    }else {
                                        response.getWriter().println("<script>alert('Description Change Failed. You can try it again.');window.location.href='/logout'</script>");
                                    }
                                }else {
                                    // no access
                                    response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                                }

                            }
                        }

                        // Change To Developer
                        if (type.equals("developer")) {
                            //verify the username and password
                            User webuser = userService.login(userName, request.getParameter("psw"));
                            if(webuser == null) {
                                response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                            }else {
                                if (userService.changeToDeveloper(userId, userName)) {
                                    response.getWriter().println("<script>alert('You are a developer now. Congratulation!');window.location.href='/logout'</script>");
                                }else {
                                    response.getWriter().println("<script>alert('Sorry, Change Failed. Please Try Again');window.location.href='/logout'</script>");
                                }
                            }
                        }

                        // Change Avatar
                        if (type.equals("avatar")) {
                            String fileNameTemp = null;
                            String fileName = "avatar.jpg";
                            String savepath = this.getServletContext().getRealPath("/image/avatar");
                            String userPassword = "";
                            try {
                                //get parse factory
                                DiskFileItemFactory factory = new DiskFileItemFactory();

                                //according to parse factory, get the parser
                                ServletFileUpload upload = new ServletFileUpload(factory);

                                //judge the form type
                                if(!upload.isMultipartContent(request)) {
                                    return;
                                }
                                //if it is upload form, need to parse data
                                //parse all the parameter request

                                List<FileItem> list = upload.parseRequest(request);

                                //Iterate through the list collection
                                int i=1;
                                for(FileItem item : list) {
                                    if(item.isFormField()) {
                                        //represent the normal field
                                        // get user register information
                                        if(i==1) {
                                            userPassword = item.getString();
                                        }
                                        i++;
                                    }else {
                                        //represent the upload field
                                        //need upload the Specified file
                                        //get the entire file path
                                        fileNameTemp = item.getName();
                                        //get the real file name
                                        fileNameTemp = fileNameTemp.substring(fileNameTemp.lastIndexOf("\\")+1);
                                        if (fileNameTemp.equals("")) {
                                            System.out.println("Not Avatar");
                                        }else {
                                            String fileType = fileNameTemp.substring(fileNameTemp.indexOf(".") + 1, fileNameTemp.length());
                                            fileName = userName + "_" + generateUserId() + "." + fileType;
                                        }

                                        InputStream in = item.getInputStream();
                                        int hasRead=0;
                                        byte [] buffer = new byte[1024];

                                        System.out.println(savepath);
                                        //write data in Specified space
                                        FileOutputStream fos = new FileOutputStream(savepath+"/"+fileName);


                                        while((hasRead=in.read(buffer))!=-1) {
                                            fos.write(buffer, 0, hasRead);
                                        }
                                        in.close();
                                        fos.close();

                                        HttpSession session = request.getSession();
                                        session.setAttribute("avatar", fileName);
                                    }
                                }
                                //verify the username and password
                                User webuser = userService.login(userName, userPassword);
                                if(webuser == null) {
                                    response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                                }else {
                                    if (userService.changeAvatar(userId, fileName, savepath)) {
                                        response.getWriter().println("<script>alert('Avatar Change Successful.');window.location.href='/logout'</script>");
                                    }else {
                                        response.getWriter().println("<script>alert('Avatar Change Failed');window.location.href='/console'</script>");
                                    }
                                }

                            } catch (FileUploadException e) {
                                // TODO Auto-generated catch block
                                System.out.println("[team06.platform.web.controller.ChangeServlet.doPost]: " + e);
                            }
                        }

                        // Change Icon
                        if (type.equals("icon")) {
                            String fileNameTemp = null;
                            String fileName = "defaultAPP.jpg";
                            String savepath = this.getServletContext().getRealPath("/image/icon");
                            String userPassword = "";
                            try {
                                //get parse factory
                                DiskFileItemFactory factory = new DiskFileItemFactory();

                                //according to parse factory, get the parser
                                ServletFileUpload upload = new ServletFileUpload(factory);

                                //judge the form type
                                if(!upload.isMultipartContent(request)) {
                                    return;
                                }
                                //if it is upload form, need to parse data
                                //parse all the parameter request

                                List<FileItem> list = upload.parseRequest(request);

                                //Iterate through the list collection
                                int i=1;
                                for(FileItem item : list) {
                                    if(item.isFormField()) {
                                        //represent the normal field
                                        // get user register information
                                        if(i==1) {
                                            userPassword = item.getString();
                                        }
                                        i++;
                                    }else {
                                        //represent the upload field
                                        //need upload the Specified file
                                        //get the entire file path
                                        fileNameTemp = item.getName();
                                        //get the real file name
                                        fileNameTemp = fileNameTemp.substring(fileNameTemp.lastIndexOf("\\")+1);
                                        if (fileNameTemp.equals("")) {
                                            System.out.println("Not Icon");
                                        }else {
                                            String fileType = fileNameTemp.substring(fileNameTemp.indexOf(".") + 1, fileNameTemp.length());
                                            fileName = userName + "_" + generateUserId() + "." + fileType;
                                        }

                                        InputStream in = item.getInputStream();
                                        int hasRead=0;
                                        byte [] buffer = new byte[1024];

                                        System.out.println(savepath);
                                        //write data in Specified space
                                        FileOutputStream fos = new FileOutputStream(savepath+"/"+fileName);


                                        while((hasRead=in.read(buffer))!=-1) {
                                            fos.write(buffer, 0, hasRead);
                                        }
                                        in.close();
                                        fos.close();

                                        HttpSession session = request.getSession();
                                        session.setAttribute("icon", fileName);
                                    }
                                }
                                //verify the username and password
                                System.out.println("appId" + request.getSession().getAttribute("appId").toString());
                                User webuser = userService.login(userName, userPassword);
                                if(webuser == null) {
                                    response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                                }else {

                                    if (applicationService.checkAppUser(userId, request.getSession().getAttribute("appId").toString())) {
                                        if (applicationService.changeIcon(request.getSession().getAttribute("appId").toString(), fileName, savepath)) {
                                            response.getWriter().println("<script>alert('Icon Change Successful.');window.location.href='/console'</script>");
                                        }else {
                                            response.getWriter().println("<script>alert('Icon Change Failed. You can try it again.');window.location.href='/console'</script>");
                                        }
                                    }else {
                                        // no access
                                        response.sendRedirect(request.getContextPath() + "/console?error=401.4");
                                    }
                                }

                            } catch (FileUploadException e) {
                                // TODO Auto-generated catch block
                                System.out.println("[team06.platform.web.controller.ChangeServlet.doPost]: " + e);
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

    private Long generateUserId() {
        return System.currentTimeMillis();
    }
}

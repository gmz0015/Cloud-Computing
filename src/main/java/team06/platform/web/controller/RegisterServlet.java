package team06.platform.web.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import team06.platform.domain.User;
import team06.platform.service.IAccountService;
import team06.platform.service.IDatabaseService;
import team06.platform.service.IUserService;
import team06.platform.service.impl.AccountServiceImpl;
import team06.platform.service.impl.DatabaseServiceImpl;
import team06.platform.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();
    private IAccountService accountService = new AccountServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        String referer = null;
        String username = null;
        String password = null;
        String email = null;
        String avatar = null;
        String role = "USER";
        String fileNameTemp = null;
        String fileName = "avatar.jpg";

        //use regular expressions to show a email format
        final String format = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(format);

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
                        referer = item.getString();
                    } else if(i==2) {
                        username = item.getString();
                    } else if(i==3) {
                        password = item.getString();
                    } else if(i==4) {
                        email =item.getString();

                        //verify whether the mailbox is legal or not
                        final Matcher mat = pattern.matcher(email);
                        if (!mat.find()) {
                            pw.println("<script>alert('email address is illegal!');window.location.href='/login'</script>");
                            return;
                        }
                    } else if(i==5) {
                        role = item.getString();
                    }
                    i++;
                }else {
                    //represent the upload field
                    //need upload the Specified file
                    //get the entire file path
                    fileNameTemp = item.getName();
                    //get the real file name
                    fileNameTemp = fileNameTemp.substring(fileNameTemp.lastIndexOf("\\")+1);
                    System.out.println("TEST fileName" + fileNameTemp);
                    if (fileNameTemp.equals("")) {
                        System.out.println("Not Avatar");
                    }else {
                        String fileNamePre = fileNameTemp.substring(fileNameTemp.indexOf("=") + 1, fileNameTemp.indexOf("."));
                        String fileType = fileNameTemp.substring(fileNameTemp.indexOf(".") + 1, fileNameTemp.length());
                        fileName = username + "_" + generateUserId() + "." + fileType;
                    }

                    InputStream in = item.getInputStream();
                    int hasRead=0;
                    byte [] buffer = new byte[1024];

                    String savepath = this.getServletContext().getRealPath("/image/avatar");

                    System.out.println(savepath);
                    //write data in Specified space
                    FileOutputStream fos = new FileOutputStream(savepath+"/"+fileName);
                    //store the avatar storage path
//                    avatar = savepath+"\\"+fileName;
//                    System.out.println("avatar is:" + avatar);


                    while((hasRead=in.read(buffer))!=-1) {
                        fos.write(buffer, 0, hasRead);
                    }
                    in.close();
                    fos.close();
                    //store the username and password in the database


                    //store email information in the database

                    HttpSession session = request.getSession();
                    session.setAttribute("avatar", fileName);

                    Cookie cookie = new Cookie("JSESSIONID", session.getId());
                    cookie.setMaxAge(1*24*60*60);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
            String userId = generateUserId() + generateUserId().toString().substring(1, 4);

            if (userService.register(new User(Long.valueOf(userId), username, password, email, fileName, role))) {
                response.sendRedirect("/login");
            }else {
                pw.println("<script>alert('User name is duplicate!');window.location.href='/login'</script>");
                return;
            }

            // Create database
            if (role.equals("DEVELOPER")) {
                databaseService.createDBbyId(userId, username);
            }

            // Create account
            accountService.createAccount(Long.valueOf(userId), username);

        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private Long generateUserId() {
        return System.currentTimeMillis();
    }
}

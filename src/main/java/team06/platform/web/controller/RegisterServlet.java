package team06.platform.web.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        String username;
        String password;
        String email;
        String avatar;

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
                        username = item.getString();
                        System.out.println(username);
                    }
                    else if(i==2) {
                        password = item.getString();
                        System.out.println(password);
                    }
                    else if(i==3) {
                        email =item.getString();
                        System.out.println(email);

                        //verify whether the mailbox is legal or not
                        final Matcher mat = pattern.matcher(email);
                        if (!mat.find()) {
                            pw.println("<script>alert('email address is illegal!');window.location.href='/login.html'</script>");
                            return;
                        }
                    }
                    i++;
                }else {
                    //represent the upload field
                    //need upload the Specified file
                    //get the entire file path
                    String fileName = item.getName();
                    //get the real file name
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);

                    InputStream in = item.getInputStream();
                    int hasRead=0;
                    byte [] buffer = new byte[1024];

                    String savepath = this.getServletContext().getRealPath("/upload");
                    System.out.println(savepath);
                    //write data in Specified space
                    FileOutputStream fos = new FileOutputStream(savepath+"\\"+fileName);
                    //store the avatar storage path
                    avatar = savepath+"\\"+fileName;


                    while((hasRead=in.read(buffer))!=-1) {
                        fos.write(buffer, 0, hasRead);
                    }
                    in.close();
                    fos.close();
                    //store the username and password in the database


                    //store email information in the database

                    HttpSession session = request.getSession();
                    session.setAttribute("avatarpath",avatar);

                    Cookie cookie = new Cookie("JSESSIONID", session.getId());
                    cookie.setMaxAge(1*24*60*60);
                    cookie.setPath("/javaWEB");
                    response.addCookie(cookie);
                }
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

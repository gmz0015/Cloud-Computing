package team06.platform.web.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.yilei.cookie.Book;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JsonConfig;
//import net.sf.json.util.CycleDetectionStrategy;

@WebServlet("/getavatar")
public class getavatar extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        String avatarpath = session.getAttribute("avatarpath").toString();
        ArrayList<String> pathlist = new ArrayList<>();
        pathlist.add(avatarpath);
//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//        JSONArray json = JSONArray.fromObject(pathlist, jsonConfig);
//
//        pw.write(json.toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

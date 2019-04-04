package team06.web.bean;

import team06.domain.Database;
import team06.service.IDatabaseService;
import team06.service.IManagerService;
import team06.service.impl.DatabaseServiceImpl;
import team06.service.impl.ManagerService;
import team06.web.controller.ManagerServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class AppCreateBean extends HttpServlet implements Serializable {
    private int uploadStatus = 0;
    private int deployStatus = 0;
    private int startupStatus = 0;
    private final String SAVE_DIR = "uploadedFiles";
    private int nextStep = 0;
    private IDatabaseService databaseService = new DatabaseServiceImpl();
    private ManagerServlet managerServlet = new ManagerServlet();
    private IManagerService managerService = new ManagerService();


    public Database queryDBbyid(int userid) {
        nextStep = 1;
        return databaseService.queryDBbyid(userid);
    }

    public void doUpload(HttpServletRequest request){

    }


    /* Getter and Setter */
    public int getNextStep() { return nextStep; }

    public int getStartupStatus() { return startupStatus; }

    public int getDeployStatus() { return deployStatus; }

    public int getUploadStatus() { return uploadStatus; }
}

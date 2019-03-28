package team06.web.bean;

import javabean.UserBean;
import team06.domain.Application;
import team06.service.IApplicationService;
import team06.service.impl.ApplicationServiceImpl;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IndexBean implements Serializable {
    private String userid;
    private String username;
    private List<String> appsid;
    private List<Application> appInfo;
    private String role;

    public IndexBean() {
        IApplicationService appService = new ApplicationServiceImpl();

        int type=2;
        switch (type){
            case 0: {
                appsid = new LinkedList<>();
                userid = "2";
                username = "dev123";
                appsid.add("1");
                appsid.add("3");
                role = "Developer"; // Super Admin
                break;
            }
            case 1: {
                userid = "0";
                username = "";
                appsid = new LinkedList<>();
                role = "Guest";
                break;
            }
            case 2: {
                userid = "43";
                username = "user43";
                appsid = new LinkedList<>();
                role = "User";
                break;
            }
            case 3: {
                userid = "1";
                username = "admin111";
                appsid = new LinkedList<>();
                role = "Admin";
                break;
            }
        }

        appInfo = appService.queryAllApps();
    }

    public List<Application> getAllApps(){
        return appInfo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAppid() {
        return appsid;
    }

    public void setAppid(List<String> appid) {
        this.appsid = appid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

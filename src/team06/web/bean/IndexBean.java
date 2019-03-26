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

    private IApplicationService appService = new ApplicationServiceImpl();

    public IndexBean() {
        if (isLogin()){
            appsid = new LinkedList<>();
            userid = "1";
            username = "admin123";
            appsid.add("1");
            appsid.add("3");
            appInfo = appService.queryAllApps();
            role = "admin"; // Super Admin
        }else {
            userid = "0";
            username = "";
            appsid = new LinkedList<>();
            appInfo = new LinkedList<>();
            role = "guest";
        }
    }

    public List<Application> getAllApps(){
        return appInfo;
    }

    /**
     * Simulate authentication
     *
     * Remove Before Submit
     */
    private boolean isLogin() {
        return true;
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

package team06.web.bean;

import team06.domain.Application;
import team06.service.IApplicationService;
import team06.service.impl.ApplicationServiceImpl;

import java.io.Serializable;
import java.util.List;

public class IndexBean implements Serializable {
    private String userid;
    private String username;
    private List<String> appsid;
    private List<Application> appInfo;
    private String role;

    public IndexBean() {
        IApplicationService appService = new ApplicationServiceImpl();
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

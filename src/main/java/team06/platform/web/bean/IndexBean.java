package team06.platform.web.bean;

import team06.platform.domain.Application;
import team06.platform.service.IApplicationService;
import team06.platform.service.impl.ApplicationServiceImpl;

import java.io.Serializable;
import java.util.List;

public class IndexBean implements Serializable {
    private String userId;
    private String userName;
    private List<String> appsId;
    private List<Application> appInfo;
    private String role;

    public IndexBean() {
        IApplicationService appService = new ApplicationServiceImpl();
        appInfo = appService.getAllApps();
    }

    public List<Application> getAllApps(){
        return appInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getAppsId() {
        return appsId;
    }

    public void setAppsId(List<String> appsId) {
        this.appsId = appsId;
    }

    public List<Application> getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(List<Application> appInfo) {
        this.appInfo = appInfo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

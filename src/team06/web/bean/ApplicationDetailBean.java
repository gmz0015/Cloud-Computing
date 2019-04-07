package team06.web.bean;

import team06.domain.Application;
import team06.service.IApplicationService;
import team06.service.IDatabaseService;
import team06.service.impl.ApplicationServiceImpl;
import team06.service.impl.DatabaseServiceImpl;

import java.io.Serializable;

public class ApplicationDetailBean implements Serializable {
    private String userid;
    private String appid;
    private Application appInfo;

    private IApplicationService appService = new ApplicationServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public ApplicationDetailBean() {}

    public Application doQuery() {
        appInfo = appService.getAppByAppId(appid);
        return appInfo;
    }

    public Application getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(Application appInfo) {
        this.appInfo = appInfo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}

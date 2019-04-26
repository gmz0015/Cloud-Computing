package team06.platform.web.bean;

import team06.platform.domain.Application;
import team06.platform.service.IApplicationService;
import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.service.impl.DatabaseServiceImpl;

import java.io.Serializable;

public class ApplicationDetailBean implements Serializable {
    private String userId;
    private String appId;
    private Application appInfo;

    private IApplicationService appService = new ApplicationServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public ApplicationDetailBean() {}

    public Application doQuery() {
        appInfo = appService.getAppByAppId(appId);
        return appInfo;
    }

    public Application getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(Application appInfo) {
        this.appInfo = appInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

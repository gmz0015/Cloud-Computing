package team06.platform.web.bean;

import team06.platform.domain.Application;
import team06.platform.domain.Database;
import team06.platform.service.IApplicationService;
import team06.platform.service.IDatabaseService;
import team06.platform.service.impl.ApplicationServiceImpl;
import team06.platform.service.impl.DatabaseServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationBean implements Serializable {
    private String userid;
    private List<Application> appInfo;
    private Integer total = 0;
    private Integer running = 0;
    private Integer stop = 0;
    private Integer undeploy = 0;

    private IApplicationService appService = new ApplicationServiceImpl();
    private IDatabaseService databaseService = new DatabaseServiceImpl();

    public ApplicationBean(){
        appInfo = new ArrayList<>();
    }

    public Database queryDBbyid(String userid) {
        return databaseService.queryDBbyid(userid);
    }

    /**
     * Invoke service to query Database and retrieve applications data
     */
    public void doQuery(){
        appInfo = appService.getAppByUserId(userid);
        count();
    }

    private void count(){
        for (Application application: appInfo) {
            total += 1;
            if (application.getStatus() == 0)
                undeploy += 1;
            else if (application.getStatus() == 1)
                stop += 1;
            else if (application.getStatus() == 2)
                running += 1;
        }
    }

    public List<Application> getAppInfo() {
        return appInfo;
    }



    /* Setter and Getter */

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRunning() {
        return running;
    }

    public void setRunning(Integer running) {
        this.running = running;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public Integer getUndeploy() {
        return undeploy;
    }

    public void setUndeploy(Integer undeploy) {
        this.undeploy = undeploy;
    }

    public void setAppInfo(List<Application> appInfo) {
        this.appInfo = appInfo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}

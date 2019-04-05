package team06.web.bean;

import team06.domain.Application;
import team06.domain.Database;
import team06.service.IApplicationService;
import team06.service.IDatabaseService;
import team06.service.impl.ApplicationServiceImpl;
import team06.service.impl.DatabaseServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationBean implements Serializable {
    private String userid;
    private List<Application> appInfo;

    /* Maybe REMOVE */
    private List<String> appid;
    private List<String> appname;
    private List<Integer> visits;
    private List<Double> rating;
    private List<Integer> status;
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
        appInfo = appService.queryAppById(userid);
    }

    public List<Application> getAppInfo() {
        return appInfo;
    }



    /* Setter and Getter */

    public void setAppInfo(List<Application> appInfo) {
        this.appInfo = appInfo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<String> getAppid() {
        return appid;
    }

    public void setAppid(List<String> appid) {
        this.appid = appid;
    }

    public List<String> getAppname() {
        return appname;
    }

    public void setAppname(List<String> appname) {
        this.appname = appname;
    }

    public List<Integer> getVisits() {
        return visits;
    }

    public void setVisits(List<Integer> visits) {
        this.visits = visits;
    }

    public List<Double> getRating() {
        return rating;
    }

    public void setRating(List<Double> rating) {
        this.rating = rating;
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }
}

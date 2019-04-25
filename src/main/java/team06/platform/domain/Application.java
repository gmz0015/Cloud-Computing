package team06.platform.domain;

public class Application {
    private String appid;
    private String name;
    private String description;
    private String ownerid;
    private String ownername;
    private int visits;
    private double rating;
    private int status;
    private String dbid;
    private String warpath;
    private String contextpath;
    private String iconPath;

    public Application(String appid, String name, String description, String ownerid, String ownername, int visits, double rating, int status, String dbid, String warpath, String contextpath, String iconPath) {
        this.appid = appid;
        this.name = name;
        this.description = description;
        this.ownerid = ownerid;
        this.ownername = ownername;
        this.visits = visits;
        this.rating = rating;
        this.status = status;
        this.dbid = dbid;
        this.warpath = warpath;
        this.contextpath = contextpath;
        this.iconPath = iconPath;
    }


    /* Getter and Setter */

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getWarpath() {
        return warpath;
    }

    public void setWarpath(String warpath) {
        this.warpath = warpath;
    }

    public String getContextpath() {
        return contextpath;
    }

    public void setContextpath(String contextpath) {
        this.contextpath = contextpath;
    }

    public String getDbid() { return dbid; }

    public void setDbid(String dbid) { this.dbid = dbid; }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerid() { return ownerid; }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

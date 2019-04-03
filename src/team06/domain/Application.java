package team06.domain;

public class Application {
    private Integer appid;
    private String name;
    private int ownerid;
    private String ownername;
    private int visits;
    private double rating;
    private int status;
    private String dbusername;
    private String dbpassword;
    private String dbname;

    public Application(Integer appid, String name, int ownerid, String ownername, int visits, double rating, int status, String dbusername, String dbpassword, String dbname) {
        this.appid = appid;
        this.name = name;
        this.ownerid = ownerid;
        this.ownername = ownername;
        this.visits = visits;
        this.rating = rating;
        this.status = status;
        this.dbusername = dbusername;
        this.dbpassword = dbpassword;
        this.dbname = dbname;
    }

    /* Getter and Setter */

    public String getDbusername() {
        return dbusername;
    }

    public void setDbusername(String dbusername) {
        this.dbusername = dbusername;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
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

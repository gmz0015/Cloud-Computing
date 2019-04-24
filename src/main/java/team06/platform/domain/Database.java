package team06.platform.domain;

public class Database {
    private String dbid;
    private String userid;
    private String dbname;
    private String dbusername;
    private String dbpassword;

    public Database(String dbid, String userid, String dbname, String dbusername, String dbpassword) {
        this.dbid = dbid;
        this.userid = userid;
        this.dbname = dbname;
        this.dbusername = dbusername;
        this.dbpassword = dbpassword;
    }

    /* Getter and Setter */
    public String getDbid() {
        return dbid;
    }

    public void setDbid(String dbid) {
        this.dbid = dbid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

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
}

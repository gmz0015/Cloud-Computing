package team06.domain;

public class Database {
    private int dbid;
    private int userid;
    private String dbname;
    private String dbusername;
    private String dbpassword;

    public Database(int dbid, int userid, String dbname, String dbusername, String dbpassword) {
        this.dbid = dbid;
        this.userid = userid;
        this.dbname = dbname;
        this.dbusername = dbusername;
        this.dbpassword = dbpassword;
    }

    /* Getter and Setter */
    public int getDbid() {
        return dbid;
    }

    public void setDbid(int dbid) {
        this.dbid = dbid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
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

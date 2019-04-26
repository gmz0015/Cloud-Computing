package team06.platform.domain;

/**
 * For AdminBean.java
 * Store the user info within database
 */
public class DBUser {
    private String userName;
    private String host;

    public DBUser(String userName, String host) {
        this.userName = userName;
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}

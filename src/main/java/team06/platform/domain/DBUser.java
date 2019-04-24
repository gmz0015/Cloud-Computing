package team06.platform.domain;

/**
 * For AdminBean.java
 * Store the user info within database
 */
public class DBUser {
    private String username;
    private String host;

    public DBUser(String username, String host) {
        this.username = username;
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}

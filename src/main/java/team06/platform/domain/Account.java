package team06.platform.domain;

public class Account {
    private String userid;

    private String username;

    private Integer balance;

    public Account(String userid, String username, Integer balance) {
        this.userid = userid;
        this.username = username;
        this.balance = balance;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}

package team06.platform.domain;

public class Account {
    private Long userId;

    private String username;

    private Integer balance;

    public Account(Long userId, String username, Integer balance) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

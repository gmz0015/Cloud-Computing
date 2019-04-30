package team06.platform.domain;

public class Charge {
    private Long userId;
    private Long appId;

    public Charge(Long userId, Long appId) {
        this.userId = userId;
        this.appId = appId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
}

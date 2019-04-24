package team06.platform.service;

public interface IAccountService {
    Integer getBalance(String userid);

    Integer withdrawal(String userid, Integer amount);

    Integer deposit(String userid, Integer amount);

    void transfer(String fromUserId, String toUserId, String type, String appId, Integer amount);
}

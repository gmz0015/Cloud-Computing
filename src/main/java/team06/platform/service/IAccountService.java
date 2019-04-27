package team06.platform.service;

import team06.platform.domain.Transaction;

import java.util.List;

public interface IAccountService {
    void createAccount(Long userId, String userName);

    Integer getBalance(Long userid);

    Integer withdrawal(Long userid, Integer amount);

    Integer deposit(Long userid, Integer amount);

    void charge(Long fromUserId, Long appId, Integer amount);

    Boolean transfer(Long fromUserId, Long toUserId, String type, Long appId, Integer amount);

    List<Transaction> getTransaction(Long userId);

    List<Transaction> getAppTransaction(Long appId);
}

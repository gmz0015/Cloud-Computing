package team06.platform.service;

import team06.platform.domain.Transaction;

import java.util.List;

public interface IAccountService {
    Integer getBalance(Long userid);

    Integer withdrawal(Long userid, Integer amount);

    Integer deposit(Long userid, Integer amount);

    Boolean transfer(Long fromUserId, Long toUserId, String type, Long appId, Integer amount);

    List<Transaction> getTransaction(Long userid);
}

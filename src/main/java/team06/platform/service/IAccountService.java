package team06.platform.service;

import team06.platform.domain.Charge;
import team06.platform.domain.Transaction;

import java.util.List;

public interface IAccountService {
    void createAccount(Long userId, String userName);

    Double getBalance(Long userid);

    Double withdrawal(Long userid, Double amount);

    Double deposit(Long userid, Double amount);

    void charge(Long fromUserId, Long appId, Double amount);

    /**
     * For mode 2. pay for bank
     * @param fromUserId
     * @param toUserId
     * @param type
     * @param appId
     * @param amount
     * @return
     */
    Boolean transfer2(Long fromUserId, Long toUserId, String type, Long appId, Double devAmount, Double amount);

    /**
     * For mode 3. pay for login, bank
     * @param fromUserId
     * @param toUserId
     * @param type
     * @param appId
     * @param amount
     * @return
     */
    Boolean transfer3(Long fromUserId, Long toUserId, String type, Long appId, Double devAmount, Double amount);

    List<Transaction> getTransaction(Long userId);

    List<Transaction> getAppTransaction(Long appId);

    Boolean isCharge(Charge charge);
}

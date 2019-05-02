package team06.platform.dao;

import team06.platform.domain.Account;
import team06.platform.domain.Charge;
import team06.platform.domain.Transaction;

import java.util.List;

public interface IAccountDao {

    void insertAccount(Long userId, String userName);

    Double queryBalance(Long userId);

    boolean updateBalance(Account account);

    boolean insertTransaction(Transaction transaction);

    boolean insertCharge(Charge charge);

    boolean deleteCharge(Long userId);

    List<Charge> queryCharge(Long userId);

    List<Transaction> queryTransaction(Long userId);

    List<Transaction> queryAppTransaction(Long appId);
}

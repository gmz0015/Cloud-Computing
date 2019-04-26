package team06.platform.dao;

import team06.platform.domain.Account;
import team06.platform.domain.Transaction;

import java.util.List;

public interface IAccountDao {

    Integer queryBalance(Long userId);

    boolean updateBalance(Account account);

    boolean insertTransaction(Transaction transaction);

    List<Transaction> queryTransaction(Long userId);

    List<Transaction> queryAppTransaction(Long appId);
}

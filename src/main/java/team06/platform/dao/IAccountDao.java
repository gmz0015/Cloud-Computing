package team06.platform.dao;

import team06.platform.domain.Account;
import team06.platform.domain.Transaction;

public interface IAccountDao {

    Integer queryBalance(String userid);

    boolean updateBalance(Account account);

    boolean insertTransaction(Transaction transaction);
}

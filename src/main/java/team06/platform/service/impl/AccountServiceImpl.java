package team06.platform.service.impl;

import team06.platform.dao.IAccountDao;
import team06.platform.dao.impl.AccountDaoImpl;
import team06.platform.domain.Account;
import team06.platform.domain.Transaction;
import team06.platform.service.IAccountService;

import java.sql.Timestamp;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public Integer getBalance(String userid) {
        return  accountDao.queryBalance(userid);
    }

    @Override
    public Integer withdrawal(String userid, Integer amount) {
        Integer currentBalance = accountDao.queryBalance(userid);
        Integer newBalance = currentBalance - amount;
        accountDao.updateBalance(new Account(userid, "", newBalance));
        return newBalance;
    }

    @Override
    public Integer deposit(String userid, Integer amount) {
        Integer currentBalance = accountDao.queryBalance(userid);
        Integer newBalance = currentBalance + amount;
        accountDao.updateBalance(new Account(userid, "", newBalance));
        return newBalance;
    }

    @Override
    public void transfer(String fromUserId, String toUserId, String type, String appId, Integer amount) {
        this.withdrawal(fromUserId, amount);
        this.deposit(toUserId, amount);
        accountDao.insertTransaction(new Transaction(fromUserId, "TEST", toUserId, "TEST", type, appId, amount, new Timestamp(1)));
    }


}

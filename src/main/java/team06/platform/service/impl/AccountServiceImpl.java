package team06.platform.service.impl;

import team06.platform.dao.IAccountDao;
import team06.platform.dao.impl.AccountDaoImpl;
import team06.platform.domain.Account;
import team06.platform.domain.Transaction;
import team06.platform.service.IAccountService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public Integer getBalance(Long userId) {
        return  accountDao.queryBalance(userId);
    }

    @Override
    public Integer withdrawal(Long userId, Integer amount) {
        Integer currentBalance = accountDao.queryBalance(userId);
        Integer newBalance = currentBalance - amount;
        accountDao.updateBalance(new Account(userId, "", newBalance));
        return newBalance;
    }

    @Override
    public Integer deposit(Long userid, Integer amount) {
        Integer currentBalance = accountDao.queryBalance(userid);
        Integer newBalance = currentBalance + amount;
        accountDao.updateBalance(new Account(userid, "", newBalance));
        return newBalance;
    }

    @Override
    public Boolean transfer(Long fromUserId, Long toUserId, String type, Long appId, Integer amount) {
        Date date = new Date();
        this.withdrawal(fromUserId, amount);
        this.deposit(toUserId, amount);
        accountDao.insertTransaction(new Transaction(fromUserId, "TEST", toUserId, "TEST", type, appId, amount, new Timestamp(date.getTime())));
        return true;
    }

    @Override
    public List<Transaction> getTransaction(Long userId) {
        return accountDao.queryTransaction(userId);
    }

    @Override
    public List<Transaction> getAppTransaction(Long appId) {
        return accountDao.queryAppTransaction(appId);
    }


}

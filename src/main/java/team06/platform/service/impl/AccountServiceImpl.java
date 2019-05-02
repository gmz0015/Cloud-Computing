package team06.platform.service.impl;

import team06.platform.dao.IAccountDao;
import team06.platform.dao.IApplicationDao;
import team06.platform.dao.IUserDao;
import team06.platform.dao.impl.AccountDaoImpl;
import team06.platform.dao.impl.ApplicationDaoImpl;
import team06.platform.dao.impl.UserDaoImpl;
import team06.platform.domain.Account;
import team06.platform.domain.Application;
import team06.platform.domain.Charge;
import team06.platform.domain.Transaction;
import team06.platform.service.IAccountService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    private IUserDao userDao = new UserDaoImpl();
    private IApplicationDao applicationDao = new ApplicationDaoImpl();

    @Override
    public void createAccount(Long userId, String userName) {
        accountDao.insertAccount(userId, userName);
    }

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
    public Integer deposit(Long userId, Integer amount) {
        Integer currentBalance = accountDao.queryBalance(userId);
        if (currentBalance != null) {
            Integer newBalance = currentBalance + amount;
            accountDao.updateBalance(new Account(userId, "", newBalance));
            return newBalance;
        }
        return null;
    }

    @Override
    public void charge(Long fromUserId, Long appId, Integer amount) {
        accountDao.insertCharge(new Charge(fromUserId, appId));
        Application application = applicationDao.queryAppByAppId(appId.toString());
        String ownerId = application.getOwnerId();
        String ownerName = application.getOwnerName();
        Date date = new Date();
        this.withdrawal(fromUserId, amount);
        this.deposit(Long.valueOf(ownerId), (amount - 2));
        this.deposit(Long.valueOf("1556610304306556"), 1);
        this.deposit(Long.valueOf("1556714056396556"), 1);
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf(ownerId),
                ownerName,
                "Royalties - DEV",
                appId,
                (amount - 2),
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf("1556714056396556"),
                "ChenyiLei",
                "Royalties - SignIn",
                appId,
                1,
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf("1556610304306556"),
                "MingzeGao",
                "Royalties - Bank",
                appId,
                1,
                new Timestamp(date.getTime())));
    }

    @Override
    public Boolean transfer(Long fromUserId, Long toUserId, String type, Long appId, Integer amount) {
        Date date = new Date();
        this.withdrawal(fromUserId, amount);
        this.deposit(toUserId, amount);
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                toUserId,
                userDao.queryUserInfoById(toUserId.toString()).getUserName(),
                type,
                appId,
                amount,
                new Timestamp(date.getTime())));
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

    @Override
    public Boolean isCharge(Charge charge) {
        Boolean chargeStatus = false;

        for (Charge currentCharge: accountDao.queryCharge(charge.getUserId())) {
            if (currentCharge.getAppId().equals(charge.getAppId())) {
                chargeStatus = true;
            }
        }
        return chargeStatus;
    }


}

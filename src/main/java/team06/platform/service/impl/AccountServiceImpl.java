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
    private String BANK_ID = "1556781235850556";
    private String BANK_NAME = "Peanut Bank Service";
    private String SIGN_ID = "1556714056396556";
    private String SIGN_NAME = "Sign-in Service";

    @Override
    public void createAccount(Long userId, String userName) {
        accountDao.insertAccount(userId, userName);
    }

    @Override
    public Double getBalance(Long userId) {
        return  accountDao.queryBalance(userId);
    }

    @Override
    public Double withdrawal(Long userId, Double amount) {
        Double currentBalance = accountDao.queryBalance(userId);
        Double newBalance = currentBalance - amount;
        accountDao.updateBalance(new Account(userId, "", newBalance));
        return newBalance;
    }

    @Override
    public Double deposit(Long userId, Double amount) {
        Double currentBalance = accountDao.queryBalance(userId);
        if (currentBalance != null) {
            Double newBalance = currentBalance + amount;
            accountDao.updateBalance(new Account(userId, "", newBalance));
            return newBalance;
        }
        return null;
    }

    @Override
    public void charge(Long fromUserId, Long appId, Double amount) {
        Integer chargeMode = applicationDao.queryChargeByAppId(appId.toString());
        Double rating = applicationDao.queryRating(appId.toString());
        if (chargeMode != 2) {
            Double forBank = 1.0 - rating*0.1;
            Double forLogin = 1.0 - rating*0.1;
            Double forDev = 3.0 + (1.0-forBank) + (1.0-forLogin);
            accountDao.insertCharge(new Charge(fromUserId, appId));
            Application application = applicationDao.queryAppByAppId(appId.toString());
            String ownerId = application.getOwnerId();
            String ownerName = application.getOwnerName();
            Date date = new Date();
            this.withdrawal(fromUserId, amount);
            this.deposit(Long.valueOf(ownerId), forDev);
            this.deposit(Long.valueOf(BANK_ID), forBank);
            this.deposit(Long.valueOf(SIGN_ID), forLogin);
            accountDao.insertTransaction(new Transaction(
                    fromUserId,
                    userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                    Long.valueOf(ownerId),
                    ownerName,
                    "Royalties - Dev",
                    appId,
                    forDev,
                    new Timestamp(date.getTime())));
            accountDao.insertTransaction(new Transaction(
                    fromUserId,
                    userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                    Long.valueOf(SIGN_ID),
                    SIGN_NAME,
                    "Royalties - SignIn",
                    appId,
                    forLogin,
                    new Timestamp(date.getTime())));
            accountDao.insertTransaction(new Transaction(
                    fromUserId,
                    userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                    Long.valueOf(BANK_ID),
                    BANK_NAME,
                    "Royalties - Bank",
                    appId,
                    forBank,
                    new Timestamp(date.getTime())));
        }
    }

    @Override
    public Boolean transfer2(Long fromUserId, Long toUserId, String type, Long appId, Double devAmount, Double amount) {
        Double rating = applicationDao.queryRating(appId.toString());
        Double forBank = 1.0 - rating*0.1;
        Application application = applicationDao.queryAppByAppId(appId.toString());

        Date date = new Date();
        Double left = amount - forBank - devAmount;
        if (left < 0) {
            return false;
        }else {
            this.deposit(toUserId, left);
        }
        this.withdrawal(fromUserId, amount);
        this.deposit(Long.valueOf(BANK_ID), forBank);
        this.deposit(Long.valueOf(application.getOwnerId()), devAmount);

        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                toUserId,
                userDao.queryUserInfoById(toUserId.toString()).getUserName(),
                type,
                appId,
                left,
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf(BANK_ID),
                BANK_NAME,
                "In-App - Mode 2 - Bank",
                appId,
                forBank,
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf(application.getOwnerId()),
                userDao.queryUserInfoById(application.getOwnerId()).getUserName(),
                "In-App - Mode 2 - Dev",
                appId,
                devAmount,
                new Timestamp(date.getTime())));
        return true;
    }

    @Override
    public Boolean transfer3(Long fromUserId, Long toUserId, String type, Long appId, Double devAmount, Double amount) {
        Double rating = applicationDao.queryRating(appId.toString());
        Double forBank = 1.0 - rating*0.1;
        Double forLogin = 1.0 - rating*0.1;
        Application application = applicationDao.queryAppByAppId(appId.toString());

        Date date = new Date();
        Double left = amount - forBank - forLogin - devAmount;
        if (left < 0) {
            return false;
        }else {
            this.deposit(toUserId, left);
        }
        this.withdrawal(fromUserId, amount);
        this.deposit(Long.valueOf(BANK_ID), forBank);
        this.deposit(Long.valueOf(SIGN_ID), forLogin);
        this.deposit(Long.valueOf(application.getOwnerId()), devAmount);

        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                toUserId,
                userDao.queryUserInfoById(toUserId.toString()).getUserName(),
                type,
                appId,
                left,
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf(BANK_ID),
                BANK_NAME,
                "In-App - Mode 3 - Bank",
                appId,
                forBank,
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf(SIGN_ID),
                SIGN_NAME,
                "In-App - Mode 3 - SignIn",
                appId,
                forLogin,
                new Timestamp(date.getTime())));
        accountDao.insertTransaction(new Transaction(
                fromUserId,
                userDao.queryUserInfoById(fromUserId.toString()).getUserName(),
                Long.valueOf(application.getOwnerId()),
                userDao.queryUserInfoById(application.getOwnerId()).getUserName(),
                "In-App - Mode 3 - Dev",
                appId,
                devAmount,
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

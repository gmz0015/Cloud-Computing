package team06.platform.web.bean;

import team06.platform.domain.Transaction;
import team06.platform.service.IAccountService;
import team06.platform.service.impl.AccountServiceImpl;

import java.io.Serializable;
import java.util.List;

public class AccountBean implements Serializable {
    private IAccountService accountService = new AccountServiceImpl();
    private String userId;

    public Integer getBalance() {
        return accountService.getBalance(Long.valueOf(this.userId));
    }

    public List<Transaction> getTransaction() { return accountService.getTransaction(Long.valueOf(this.userId)); }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

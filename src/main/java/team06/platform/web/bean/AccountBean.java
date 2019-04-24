package team06.platform.web.bean;

import team06.platform.service.IAccountService;
import team06.platform.service.impl.AccountServiceImpl;

import java.io.Serializable;

public class AccountBean implements Serializable {
    private IAccountService accountService = new AccountServiceImpl();
    private String userid;

    private Integer balance;

    public Integer getBalance() {
        return accountService.getBalance(this.userid);
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}

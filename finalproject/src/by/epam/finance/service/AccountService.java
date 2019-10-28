package by.epam.finance.service;

import by.epam.finance.bean.Account;
import by.epam.finance.dao.UserFactory;

public class AccountService {

    private static final AccountService accountService = new AccountService();

    private AccountService(){};

    public static AccountService getInstance(){return accountService;};

    public Account createAccount(String name, long amount) {
        Account account = new Account();
        account.setName(name);
        account.setAmount(amount);
        return account;
    }


}

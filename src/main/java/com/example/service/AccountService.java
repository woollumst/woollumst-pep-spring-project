package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import java.util.*;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private AccountService accountService;

    public AccountService(){
        accountService = new AccountService();
    }

    @Autowired
    public AccountService(AccountService accountService){
        this.accountService = accountService;
    }

    //account service methods below
    //register account
    @Autowired
    public Account registerAccount(Account newAcc){
        return accountRepository.registerAccount(newAcc); 
    }
    //login to account
    public Account loginAccount(Account qAccount){
        return accountRepository.loginAccount(qAccount);
    }

    //get all accounts?
    public List<Account> getAllAcc(){
        return accountRepository.getAllAcc();
    }
}

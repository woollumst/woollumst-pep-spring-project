package com.example.repository;

import org.springframework.stereotype.Repository;
import com.example.entity.Account;
import java.util.*;

@Repository
public class AccountRepository { //used to be interface?
    public Account registerAccount(Account newAcc){
        //logic
        return newAcc;
    }

    public Account loginAccount(Account qAccount){
        //logic
        return qAccount;
    }
    

    public List<Account> getAllAcc(){
        List<Account> accounts = new ArrayList<>();
        //logic

        return accounts;
    }

}

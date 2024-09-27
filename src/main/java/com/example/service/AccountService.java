package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.exception.*;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    List<Account> accounts;
    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    //account service methods below
    public Account registerAccount(Account newAcc){
        if(accountRepository.existsByUsername(newAcc.getUsername())){
            throw new ConflictException("Duplicate username detected!");
        }
        else if(newAcc.getPassword().length() < 4 || newAcc.getUsername().length() <= 1)
            throw new ClientException("Username can't be blank, password must be at least 4 characters long.");
        return accountRepository.save(newAcc); 
    }
    public Account loginAccount(Account qAccount){
        if(!(accountRepository.existsByUsername(qAccount.getUsername()))){
            throw new UnauthorizedException("Invalid username!");
        }
        else {
            Account sampleAcc = accountRepository.findByUsername(qAccount.getUsername());
            if(qAccount.getPassword() != sampleAcc.getPassword())
                throw new UnauthorizedException("Invalid password!");
        }
        return accountRepository.findByUsername(qAccount.getUsername());
    }
    public boolean checkUserInDB(int accID){
        return accountRepository.existsById(accID);
    }
    public List<Account> getAllAcc(){
        return accountRepository.findAll();
    }
}
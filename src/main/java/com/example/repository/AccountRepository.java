package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{ //used to be interface?
    boolean existsByUsername(String username);
    Account findByUsername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
    Account getAccountByUsernameAndPassword(String username, String password);
    /*    public Account registerAccount(Account newAcc){
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
*/
}

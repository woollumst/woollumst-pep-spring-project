package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{ //used to be interface?
    boolean existsByUsername(String username);
    Account findByusername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
    Account findByUsernameAndPassword(String username, String password);
}
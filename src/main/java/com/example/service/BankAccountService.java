package com.example.service;

import com.example.model.BankAccount;
import com.example.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Transactional
    public void transfer(int amount){
      BankAccount obamaAccount = bankAccountRepository.findByAccountId(1);
      obamaAccount.setBal(obamaAccount.getBal() - amount);
      bankAccountRepository.save(obamaAccount);
        if(true){
            throw new RuntimeException();
        }
      BankAccount trumpAccount = bankAccountRepository.findByAccountId(2);
      trumpAccount.setBal(trumpAccount.getBal() + amount);
      bankAccountRepository.save(trumpAccount);
    }
}

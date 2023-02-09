package com.example.repository;

import com.example.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount,Integer> {
    BankAccount findByAccountId(Integer id);
}

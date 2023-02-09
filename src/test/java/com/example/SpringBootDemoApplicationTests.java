package com.example;

import com.example.model.BankAccount;
import com.example.model.User;
import com.example.repository.BankAccountRepository;
import com.example.repository.UserRepository;
import com.example.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BankAccountService bankAccountService;

	@Autowired
	BankAccountRepository bankAccountRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void findByName() {
       List<User> userList = userRepository.findByUserName("Arshi");
	   System.out.println(userList);
	}

	@Test
	void findByNameAndPassword() {
		List<User> userList = userRepository.findByUserNameAndPassword("Arshi","123");
		System.out.println(userList);
	}

	@Test
	void findByNameOrPassword() {
		List<User> userList = userRepository.findByUserNameOrPassword("Arshi","123");
		System.out.println(userList);
	}

	@Test
	void findByUserNameLike() {
		List<User> userList = userRepository.findByUserNameLike("%i%");
		System.out.println(userList);
	}

	@Test
	void saveBankAccount() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBal(5000);
		bankAccount.setFirstName("obama");
		bankAccount.setLastName("barack");
        bankAccountRepository.save(bankAccount);

		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setBal(4000);
		bankAccount1.setFirstName("donald");
		bankAccount1.setLastName("trump");
		bankAccountRepository.save(bankAccount1);
	}

	@Test
	void transferAmount() {
		bankAccountService.transfer(500);
	}
}

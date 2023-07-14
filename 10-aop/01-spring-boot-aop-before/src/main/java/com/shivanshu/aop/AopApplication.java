package com.shivanshu.aop;

import com.shivanshu.aop.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {
	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	// auto inject AccountDAO dep
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			demoBeforeAdv(accountDAO);
		};
	}

	private void demoBeforeAdv(AccountDAO accountDAO) {
		accountDAO.addAccount();
	}
}

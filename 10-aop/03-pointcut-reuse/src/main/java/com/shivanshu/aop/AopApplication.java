package com.shivanshu.aop;

import com.shivanshu.aop.dao.AccountDAO;
import com.shivanshu.aop.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoBeforeAdv(accountDAO, membershipDAO);
		};
	}

	private void demoBeforeAdv(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.addAccount();

		System.out.println("Call for MembershipDAO of addAccount");
		membershipDAO.addAccount();

		System.out.println("Call for MembershipDAO of addSillyMember");
		membershipDAO.addSillyMember();

		System.out.println("Call with a specific param");
		accountDAO.addAccountWithParam(new Account());

		System.out.println("Call with two param");
		accountDAO.addAccountTwoParam(new Account(), true);
	}
}

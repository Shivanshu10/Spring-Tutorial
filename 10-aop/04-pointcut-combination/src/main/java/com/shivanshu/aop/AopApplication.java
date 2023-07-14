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

        System.out.println("Calling Getter and Setter");
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        accountDAO.getName();
        accountDAO.getServiceCode();
    }
}

package com.shivanshu.aop;

import com.shivanshu.aop.dao.AccountDAO;
import com.shivanshu.aop.dao.MembershipDAO;
import com.shivanshu.aop.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {
	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	// auto inject AccountDAO dep
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
			// demoBeforeAdv(accountDAO, membershipDAO);
			// demoAfterReturnAdv(accountDAO);
            // demoAfterThowingAdv(accountDAO);
			// demoAfterAdvice(accountDAO);
			demoAroundAdvice(trafficFortuneService);
		};
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		String data = trafficFortuneService.getFortune(true);

		System.out.println(data);
	}

	private void demoAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception err) {
			System.out.println("caught exception");
		}
		System.out.println(accounts);
	}

	private void demoAfterThowingAdv(AccountDAO accountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception err) {
            System.out.println("caught exception");
        }
        System.out.println(accounts);
    }

    private void demoAfterReturnAdv(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts(true);

		System.out.println(accounts);
	}

	private void demoBeforeAdv(AccountDAO accountDAO, MembershipDAO membershipDAO) {
	    accountDAO.addAccount();

        System.out.println("Calling Getter and Setter");
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        accountDAO.getName();
        accountDAO.getServiceCode();

		System.out.println("Calling With argument");
		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		accountDAO.addAccountWithParam(account);
	}
}

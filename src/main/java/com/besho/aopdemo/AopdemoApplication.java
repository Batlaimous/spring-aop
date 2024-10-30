package com.besho.aopdemo;

import com.besho.aopdemo.dao.AccountDAO;
import com.besho.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//demoTheafterReturningAdvice(theAccountDAO);
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\n caught exception Main Progress" + exc);
		}
		System.out.println("\n Main progress: demoTheAfterThrowingAdvice");
		System.out.println("==============");
		System.out.println(theAccounts);
		System.out.println("=============");
	}

	private void demoTheafterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		/*System.out.println("\n Main progress: demoAfterReturningAdvice");
		System.out.println("==============");
		System.out.println(theAccounts);
		System.out.println("=============");*/
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("John");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount,true);
		theMembershipDAO.goToSleep();
		theMembershipDAO.addSillyMember();
		theAccountDAO.setName("beshoooooooooo");
		theAccountDAO.setEmail("beshoy@gmail.com");
		String name= theAccountDAO.getName();
		String email = theAccountDAO.getEmail();

	}

}

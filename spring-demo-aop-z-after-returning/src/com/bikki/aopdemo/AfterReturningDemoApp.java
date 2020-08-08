package com.bikki.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bikki.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find account
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println(theAccounts);
		
//		theAccountDAO.findAccounts();
		
		
		// close spring context
		context.close();
	}

}

package com.bikki.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bikki.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find account

		List<Account> theAccounts = null;
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("\n Mani Program " + exc);
		}

		System.out.println(theAccounts);

		// close spring context
		context.close();
	}

}

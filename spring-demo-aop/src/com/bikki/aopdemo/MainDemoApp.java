package com.bikki.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bikki.aopdemo.dao.AccountDAO;
import com.bikki.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get bean
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call business method
		theAccountDAO.addAccount(new Account(), true);
		theAccountDAO.doWork();

		// call business method
		theMembershipDAO.addBDAccount();
		theMembershipDAO.goToSleep();

		// close spring context
		context.close();
	}

}

package com.bikki.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bikki.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("No soup for you!");
		}
		List<Account> myAccounts = new ArrayList<>();
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Bikki", "Gold");
		Account temp3 = new Account("Mark", "Bronze");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + " DB Work Adding Account");
	}

	public boolean doWork() {
		System.out.println(getClass() + " doing Account work");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + " getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " setServiceCode");
		this.serviceCode = serviceCode;
	}
}

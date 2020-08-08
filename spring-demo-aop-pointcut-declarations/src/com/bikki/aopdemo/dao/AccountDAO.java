package com.bikki.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.bikki.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + " DB Work Adding Account");
	}

	public boolean doWork() {
		System.out.println(getClass() + " doing Account work");
		return false;
	}
}

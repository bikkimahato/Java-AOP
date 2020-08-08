package com.bikki.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addBDAccount() {
		System.out.println(getClass() + " Adding MemberShip");
		return true;
	}

	public void goToSleep() {
		System.out.println(getClass() + " MemberShip Sleeping");
	}
}

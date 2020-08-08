package com.bikki.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bikki.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("Main Calling getFortune");
		String data = theFortuneService.getFortune();

		System.out.println("My Fortune " + data);
		System.out.println("Finished");

		// close spring context
		context.close();
	}

}

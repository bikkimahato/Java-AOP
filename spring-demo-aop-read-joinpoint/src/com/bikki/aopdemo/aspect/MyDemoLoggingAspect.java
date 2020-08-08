package com.bikki.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bikki.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.bikki.aopdemo.aspect.BikkiAOPExpressions.forDAOPackagewithoutGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====> Executing @Before advice on addAccount()");

		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method " + methodSig);

		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Accounr name: " + theAccount.getName());
				System.out.println("Accounr level: " + theAccount.getLevel());
			}
		}

	}

}

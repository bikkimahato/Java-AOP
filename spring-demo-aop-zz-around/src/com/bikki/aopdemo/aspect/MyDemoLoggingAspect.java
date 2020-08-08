package com.bikki.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	@Around("execution(* com.bikki.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=======> @Around      " + method);

		long begin = System.currentTimeMillis();

		Object result = theProceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		System.out.println((end - begin) / 1000);

		return result;
	}

	@After("execution(* com.bikki.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======> @After      " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.bikki.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======> @AfterThrowing    " + method);
		System.out.println("Exception is " + theExc);
	}

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

	@AfterReturning(pointcut = "execution(* com.bikki.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======> @AfterReturning" + method);

		System.out.println("\n=======> result " + result);

		convertAccountNamesToUpperCase(result);

		System.out.println("\n=======> Upper result " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account temp : result) {
			String upperName = temp.getName().toUpperCase();
			temp.setName(upperName);
		}

	}

}

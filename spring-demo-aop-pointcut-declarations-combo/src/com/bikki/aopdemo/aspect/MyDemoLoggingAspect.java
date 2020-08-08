package com.bikki.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.bikki.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("execution(* com.bikki.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.bikki.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackagewithoutGetterAndSetter() {
	}

	@Before("forDAOPackagewithoutGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====> Executing @Before advice on addAccount()");
	}

	@Before("forDAOPackagewithoutGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n====> API Analytics");
	}
}

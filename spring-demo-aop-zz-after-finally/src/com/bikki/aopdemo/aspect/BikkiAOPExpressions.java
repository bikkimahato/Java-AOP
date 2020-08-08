package com.bikki.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BikkiAOPExpressions {

	@Pointcut("execution(* com.bikki.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {
	}

	@Pointcut("execution(* com.bikki.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.bikki.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackagewithoutGetterAndSetter() {
	}
}

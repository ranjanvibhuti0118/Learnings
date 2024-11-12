package com.app.aop.secondaryLogic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

	@Before("execution(* com.app.aop.controllers.*.*(..))") //Point cut
	public void executeBeforeAspect(JoinPoint joinPoint) {

		System.out.println("Executing Before Aspect");
	}

	@After("execution(* com.app.aop.controllers.*.*(..))")
	public void executeAfterAspect(JoinPoint joinPoint) {

		System.out.println("Executing After Aspect");
	}


	@Around("execution(* com.app.aop.controllers.*.*(..))")
	public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		// Proceed with the method execution
		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;
		System.out.println("Executed method: " + joinPoint.getSignature().getName() + " in " + executionTime + "ms");

		return proceed; // return the result of the method execution
	}
	
	
	@AfterThrowing("execution(* com.app.aop.controllers.*.*(..))")
	public void executeAfterThrowingAspect(JoinPoint joinPoint) {

		System.out.println("Executing Throwing Aspect");
	}
}

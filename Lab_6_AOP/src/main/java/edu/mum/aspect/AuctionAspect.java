package edu.mum.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import edu.mum.domain.User;

@Aspect
@Component
public class AuctionAspect {

	// 2
	// @Pointcut("execution(* edu.mum.service..*(..))")
	// 3
	// @Pointcut("execution(* edu.mum.service..*(Long))")
	// 4
	// @Pointcut("execution(* edu.mum.service..*())")
	// public void applicationMethod() {}

	// 1
	// @Before("execution(* edu.mum.service..*(..))")
	// 2
	// @Before("applicationMethod()")
	// #6
	// @Before("within(edu.mum.service..*) && args(Long)")
//	  public void logResource(JoinPoint joinPoint) {
// 		    System.out.println();
//				    System.out.println( " ------- AUCTION TARGET CLASS : ---------- " + 
//	    			joinPoint.getSignature().getDeclaringTypeName() + "." +
//	    			joinPoint.getSignature().getName()) ;
//	  }

	@Pointcut("within(edu.mum.service..*)")
	public void applicationMethod() {
	}

	@Pointcut(" args(user)  ")
	public void userArgs(User user) {
	}

	@Before("applicationMethod() && userArgs(user)")
	public void logResourceName(JoinPoint joinPoint, User user) {
		System.out.println("=== User Full Name: " + user.getFirstName() + " " + user.getLastName());
	}

}

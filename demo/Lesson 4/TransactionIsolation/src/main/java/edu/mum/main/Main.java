package edu.mum.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import edu.mum.domain.Member;
import edu.mum.service.MemberService;
import edu.mum.service.ReadCommittedService;
import edu.mum.service.RepeatableReadService;
import edu.mum.service.TransactionService;

@Component
public class Main {

	  @Autowired
	  MemberService memberService;
	  @Autowired
	  TransactionService transactionService;
	  @Autowired
	  ReadCommittedService readCommittedService;
	  @Autowired
	  RepeatableReadService repeatableReadService;
	  
	public static void main(String[] args) {

    ApplicationContext applicationContext = 
    		new ClassPathXmlApplicationContext("context/applicationContext.xml");
    applicationContext.getBean(Main.class).mainInternal(applicationContext);
	 }
	 
  private void mainInternal(ApplicationContext applicationContext) {

     Member member = new Member();
    member.setFirstName("John");
    member.setLastName("Doe");
    member.setMemberNumber(1);
    memberService.save(member);
  
    System.out.println("Member Number: " + member.getMemberNumber());

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.println();
    System.out.print("*************HIT RETURN To DEMO Read UnCommitted - Dirty Read*********************::   ");
    System.out.println();
    try {
		in.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  
    try {
    	transactionService.readUncommitted(member);
    }
    catch (Exception e) {System.out.println("Rollback Exception - purposely thrown in readUncommitted!!"); }
    
    Member readMember = memberService.findByMemberNumber(1);
    System.out.println("Member Number: " + readMember.getMemberNumber());

    
    
    System.out.println();
    System.out.print("*************HIT RETURN To DEMO Read Committed - NO Dirty Read*********************::   ");
    System.out.println();
    try {
		in.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 
     try {
    	transactionService.readCommitted(member);
    }
    catch (Exception e) {System.out.println("Rollback Exception - purposely thrown in readCommitted!!"); }
    
    readMember = memberService.findByMemberNumber(1);
    System.out.println("Member Number: " + readMember.getMemberNumber());
 
    
    System.out.println();
    System.out.print("*************HIT RETURN To DEMO Read Committed - NON Repeatable Read*********************::   ");
    System.out.println();
    try {
		in.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

    try {
    	readCommittedService.nonRepeatableRead(member);
    }
    catch (Exception e) {
    	System.out.println("Rollback Exception!! - " + e.getMessage()); 
    	}

    
    
    System.out.println();
    System.out.print("*************HIT RETURN To DEMO Repeatable Read  - There is NO non-repeatable read  *********************::   ");
    System.out.println();
    try {
		in.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
 try {
	 repeatableReadService.repeatableRead(member);
 }
    catch (ObjectOptimisticLockingFailureException exception) {
    	System.out.println("Optimistic Locking Failed Exception" );
    }
    
    System.out.println();
    System.out.print("*************HIT RETURN To DEMO Repeatable Read  - Phantom read  *********************::   ");
    System.out.println();
    try {
		in.readLine();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 
    // Add 4 more members... total = 5
    member = new Member();
    member.setFirstName("Jim");
    member.setLastName("Dandy");
    member.setMemberNumber(2);
    memberService.save(member);
  
    member = new Member();
    member.setFirstName("Joan");
    member.setLastName("Rivers");
    member.setMemberNumber(3);
    memberService.save(member);
  
    member = new Member();
    member.setFirstName("Bill");
    member.setLastName("Bixby");
    member.setMemberNumber(4);
    memberService.save(member);
  
    member = new Member();
    member.setFirstName("Lou");
    member.setLastName("Ferringo");
    member.setMemberNumber(5);
    memberService.save(member);
  
    repeatableReadService.phantomRead();

    
  }
  
  
  }
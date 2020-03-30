package edu.mum.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Member;

import edu.mum.service.MemberService;

@Component
public class TestFindByEmailAndTotal{

	@Autowired
	MemberService memberService;
	
 		

	public void test() {
 

	 	System.out.println();
	    System.out.println("TestFindByEmailAndTotal");
 
	    // Test JPQL query
	    Member member = memberService.findByEmailAndTotalCost("lamh@gmail.com", 2.0);
	    
	    System.out.print("Member" + member.getTrips());
//	   
	    
	}
}

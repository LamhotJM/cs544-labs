package edu.mum.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Fund;
import edu.mum.domain.Member;
import edu.mum.domain.Payment;
import edu.mum.domain.Trip;
import edu.mum.service.MemberService;
import edu.mum.service.TripService;

@Component
public class TestMember {

	@Autowired
	MemberService memberService;
	
	@Autowired
	TripService tripService;

	public void setupMembers() {

		// Add 2 users for JPQL testing

		Member member = new Member();
		member.setFirstname("Lamhot");
		member.setLastname("Siagian");
		member.setNickname("Lam");
		member.setPhone("02829220");
		Calendar cal = Calendar.getInstance();
		member.setBirthDate(cal.getTime());
		member.setEmail("lamh@gmail.com");
		
	
		
		Fund fund = new Fund();
		fund.setRemainingAmount(50.0);
		fund.setTotalAmount(100.0);
		
		Payment payment = new Payment();
		payment.setDate(cal.getTime());
		payment.setDescription("paid");
		payment.setAmount(100.0);
		
		List<Payment> payments = new ArrayList<Payment>();
		payments.add(payment);
		
		memberService.save(member);
		
		Trip trip = new Trip();
		trip.setDescription("trip desc");
		trip.setDuration(23.0);
		trip.setName("Lamhot Trip");
		trip.setDepartureDate(cal.getTime());
//		trip.setStartDate(cal.getTime());
//		trip.setEndDate(cal.getTime());
		trip.setFund(fund);
		trip.setPayments(payments);
		
		tripService.save(trip);
		
		trip.getMembers().add(member);
		tripService.update(trip);
		

	}
}

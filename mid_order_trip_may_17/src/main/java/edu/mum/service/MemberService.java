package edu.mum.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;

import edu.mum.domain.Member;
import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;
 
public interface MemberService {

	public Member findByEmailAndTotalCost(String email, Double amount);

	public void save(Member member);

	public void update(Member member);

 
}

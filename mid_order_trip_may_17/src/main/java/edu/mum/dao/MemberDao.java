package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Member;
import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;

public interface MemberDao extends GenericDao<Member> {
	  
	public Member findByEmailAndTotalCost(String email,Double amount);

 }
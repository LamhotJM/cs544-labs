package edu.mum.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.dao.OrderDao;
import edu.mum.dao.ProductDao;
import edu.mum.dao.TripDao;
import edu.mum.domain.Member;
import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;
import edu.mum.service.MemberService;
import edu.mum.service.ProductService;
import edu.mum.service.TripService;

@Service
@Transactional 
public class MemberServiceImpl implements MemberService {
	
 	@Autowired
	private MemberDao memberDao;

	@Override
	public Member findByEmailAndTotalCost(String email, Double amount) {
		// TODO Auto-generated method stub
		return memberDao.findByEmailAndTotalCost(email, amount);
	}

	@Override
	public void save(Member member) {
	   memberDao.save(member);
	}

	@Override
	public void update(Member member) {
		 memberDao.update(member);
		
	}



 
}

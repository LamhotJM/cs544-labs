package edu.mum.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.MemberDao;
import edu.mum.dao.ProductDao;
import edu.mum.dao.TripDao;
import edu.mum.domain.Member;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;

@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(Member.class);
	}

	@Override
	public Member findByEmailAndTotalCost(String email, Double amount) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select m from Member m, Trip t "
				+ "where m.email =:email and t member of m.trips " + "and t.fund.totalAmount > :amount");

		return (Member) query.setParameter("email", email).setParameter("amount", amount).getSingleResult();
	}

}
package edu.mum.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;

@Service
@Transactional 
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

    public void save( Member member) {  		
		memberDao.save(member);
	}
	
    public void update( Member member) {  		
		memberDao.update(member);
	}
	
  	
	public List<Member> findAll() {
		return (List<Member>)memberDao.findAll();
	}

	public Member findByMemberNumber(Integer memberId) {
		return memberDao.findByMemberNumber(memberId);
	}
 
	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}
	
	public Member findByNativeQuery(Integer number) {
		return memberDao.findByNativeQuery(number);
	}

	public Member findByNamedQuery(Integer number) {
		return memberDao.findByNamedQuery(number);
	}
	
	public List<Member> findByAddressState(String state,Integer age) {
		return memberDao.findByAddressState(state,age);
	} 
}

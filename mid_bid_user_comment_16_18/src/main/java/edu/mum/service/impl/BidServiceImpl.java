package edu.mum.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.BidDao;
import edu.mum.dao.GenericDao;
import edu.mum.dao.UserDao;
import edu.mum.domain.Bid;
import edu.mum.domain.User;

@Service
@Transactional 
public class BidServiceImpl implements edu.mum.service.BidService{
	
 	@Autowired
	private BidDao bidDao;

 	
     public void save( Bid bid) {  		
  		bidDao.save(bid);
 	}
  	
  	
	public List<Bid> findAll() {
		return (List<Bid>)bidDao.findAll();
	}

 	public void update(Bid bid) {
		 bidDao.update(bid);

	}
}

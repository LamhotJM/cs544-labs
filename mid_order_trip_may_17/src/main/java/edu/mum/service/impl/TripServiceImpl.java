package edu.mum.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OrderDao;
import edu.mum.dao.ProductDao;
import edu.mum.dao.TripDao;
import edu.mum.domain.Member;
import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;
import edu.mum.service.ProductService;
import edu.mum.service.TripService;

@Service
@Transactional 
public class TripServiceImpl implements TripService {
	
 	@Autowired
	private TripDao tripDao;


	@Override
	public List<Trip> findAllBatch() {
		// TODO Auto-generated method stub
		return tripDao.findAllBatch();
	}   
	

	@Override
	public void save(Trip trip) {
	   tripDao.save(trip);
	}

	@Override
	public void update(Trip trip) {
		 tripDao.update(trip);
		
	}
 
}

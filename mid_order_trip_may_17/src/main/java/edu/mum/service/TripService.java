package edu.mum.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;

import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;
 
public interface TripService {

	public List<Trip> findAllBatch();
	
	public List<Trip> findTripsbyDateAndPassengerCount(Integer passengerCount);
	
	public void save(Trip trip);
	
	public void update(Trip trip);

 
}

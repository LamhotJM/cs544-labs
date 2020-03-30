package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;

public interface TripDao extends GenericDao<Trip> {
	  
	public List<Trip> findAllBatch();

	public List<Trip> findTripsbyDateAndPassengerCount(Integer passengerCount);

 }
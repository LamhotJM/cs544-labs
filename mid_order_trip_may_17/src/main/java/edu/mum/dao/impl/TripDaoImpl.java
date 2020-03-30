package edu.mum.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ProductDao;
import edu.mum.dao.TripDao;
import edu.mum.domain.Product;
import edu.mum.domain.Trip;

@SuppressWarnings("unchecked")
@Repository
public class TripDaoImpl extends GenericDaoImpl<Trip> implements TripDao {

	public TripDaoImpl() {
		super.setDaoType(Trip.class);
	}

	public List<Trip> findAllBatch() {
		List<Trip> trips = (List<Trip>) this.findAll();
		for (Trip trip : trips) {
			if (!trip.getPayments().isEmpty())
				trip.getPayments().get(0);

		}
		return trips;

	}

}
package edu.mum.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToMany(fetch= FetchType.EAGER,cascade= { CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="passengers")
	List<Booking> bookings;
	

}

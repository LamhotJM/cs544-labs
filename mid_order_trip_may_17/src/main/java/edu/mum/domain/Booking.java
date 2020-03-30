package edu.mum.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Booking {	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date bookingDate;
	
	@ManyToMany(cascade= { CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="booking_passenger", joinColumns= {@JoinColumn(name="booking_id")},
	inverseJoinColumns= {@JoinColumn(name="passenger_id")})
	private List<Passenger> passengers = new ArrayList<Passenger>();;
	
	
}

package edu.mum.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 20)
	private String name;
	@Column(length = 200)
	private String description;

	@Column
	private Double duration;

	@Column
	private Date departureDate;


	// do not forget change to lazy to test assumption
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "trip_id")
	List<Booking> bookings = new ArrayList<Booking>();
	
	//here another additional code
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "station_id")
	private Station station;
	
	
	
//	@Temporal(TemporalType.DATE)
//	private Date startDate;
//
//	@Temporal(TemporalType.DATE)
//	private Date endDate;
	

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "trip_member", joinColumns = { @JoinColumn(name = "trip_id") }, inverseJoinColumns = {
			@JoinColumn(name = "member_id") })
	List<Member> members = new ArrayList<Member>();

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "fund_id")
	Fund fund;

	// do not forget change to lazy to test assumption
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "trip_id")
	List<Payment> payments = new ArrayList<Payment>();

	public Trip() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

//	public Date getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//
//	public Date getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", name=" + name + ", description=" + description + ", duration=" + duration
				+  "]";
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

}

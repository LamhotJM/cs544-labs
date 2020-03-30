package edu.mum.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Station {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	//@Fetch(FetchMode.SUBSELECT)
	List<Trip> trips = new ArrayList<Trip>();

}

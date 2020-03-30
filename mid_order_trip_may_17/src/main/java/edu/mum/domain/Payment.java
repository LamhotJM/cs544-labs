package edu.mum.domain;


import java.util.Date;

import javax.persistence.*;

@Entity
public class Payment {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=200)
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column
	private Double amount;
	
	
	public  Payment(){
		
	}
	
	

	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}

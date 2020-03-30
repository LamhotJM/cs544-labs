package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPMENT")
public class Shipment {

	public Shipment() {
		// TODO Auto-generated constructor stub
	}

	public Shipment(Address deliveryAddress, User buyer, User seller) {
		super();
		this.deliveryAddress = deliveryAddress;
		this.buyer = buyer;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Id
	@GeneratedValue
	private Long id = null;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DELIVERY_ADDRESS_ID")
	private Address deliveryAddress;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BUYER_ID")
	private User buyer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Seller_ID")
	private User seller;

}

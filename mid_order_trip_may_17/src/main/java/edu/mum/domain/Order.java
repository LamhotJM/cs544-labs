package edu.mum.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "purchaseOrder")
public class Order {
	@Override
	public String toString() {
		return "Order [id=" + id + ", version=" + version + ", orderNumber=" + orderNumber + ", items=" + items
				+ "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDENTIFIER", updatable = false, nullable = false)
	private Long id = null;
	@Version
	@Column(name = "VERSION")
	private int version = 0;

	@Column(length = 128)
	private String orderNumber;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<OrderItem> items = new HashSet<OrderItem>();

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<OrderPayment> payments = new HashSet<OrderPayment>();

	public Order(String orderNumber, Set<OrderItem> items) {
		this.orderNumber = orderNumber;
		this.items = items;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Set<OrderPayment> getPayments() {
		return payments;
	}

	public void setPayments(Set<OrderPayment> payments) {
		this.payments = payments;
	}

	public void addOrderItem(OrderItem orderItem) {
		this.items.add(orderItem);
		orderItem.setOrder(this);
	}

	public void addOrderPayment(OrderPayment orderPayment) {
		this.payments.add(orderPayment);
		orderPayment.setOrder(this);
	}

}

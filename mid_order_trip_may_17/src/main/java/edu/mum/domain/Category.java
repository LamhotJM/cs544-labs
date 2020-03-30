package edu.mum.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Category {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
    
    @Column(name="NAME", length=128)
    String name;
    
    @Column(name="DESCRIPTION")
    String description;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable ( name="Category_Product", joinColumns={@JoinColumn(name="CategoryID")},  
    inverseJoinColumns={ @JoinColumn(name="ProductID")} )  
    Set<Product> products = new HashSet<Product>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

 	public void addProduct(Product product) {
		this.products.add(product);
//		product.getCategories().add(this);
	}

}

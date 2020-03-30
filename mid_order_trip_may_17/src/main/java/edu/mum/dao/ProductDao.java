package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Order;
import edu.mum.domain.Product;

public interface ProductDao extends GenericDao<Product> {
	  
	public List<Product> findByAmountRangeAndQuantity(Integer minPayment, Integer maxPayment,Integer quantity);

 }
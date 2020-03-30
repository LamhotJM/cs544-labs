package edu.mum.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;

import edu.mum.domain.Order;
import edu.mum.domain.Product;
 
public interface ProductService {

	public List<Product> findByAmountRangeAndQuantity(Integer minPayment, Integer maxPayment, Integer quantity);

 
}

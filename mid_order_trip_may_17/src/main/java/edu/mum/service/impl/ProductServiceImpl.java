package edu.mum.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OrderDao;
import edu.mum.dao.ProductDao;
import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService {
	
 	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findByAmountRangeAndQuantity(Integer minPayment, Integer maxPayment, Integer quantity) {
		// TODO Auto-generated method stub
		return productDao.findByAmountRangeAndQuantity(minPayment, maxPayment, quantity);
	}   
 
}

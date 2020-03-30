package edu.mum.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Product;

@SuppressWarnings("unchecked")
@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	public ProductDaoImpl() {
		super.setDaoType(Product.class);
	}

	public List<Product> findByAmountRangeAndQuantity(Integer minPayment, Integer maxPayment, Integer quantity) {

		Query query = entityManager
				.createQuery("select p from Product p, OrderItem oi, OrderPayment op where oi.product = p and "
						+ "oi.quantity > :quantity and op member of oi.order.payments "
						+ "and op.amount > :minPayment and op.amount < :maxPayment");
		return (List<Product>) query.setParameter("maxPayment", maxPayment).setParameter("minPayment", minPayment)
				.setParameter("quantity", quantity).getResultList();
	}

}
package edu.mum.dao.impl;

 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;

 


@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public OrderDaoImpl() {
		super.setDaoType(Order.class );
		}

	public Order findByGraph(Long id) {

	    EntityGraph graph = entityManager.getEntityGraph("graph.Order.items");

	    Map hints = new HashMap();
	    hints.put("javax.persistence.fetchgraph", graph);

		Order order = this.findOne(id, hints);
		return order;

	}
	
	public List<Order> findAllJoinFetch()
	{
		Query query= entityManager.createQuery("SELECT o FROM  Order as o JOIN FETCH o.items as i");
		List<Order> orders = query.getResultList();
		return orders;
	}

 
 }
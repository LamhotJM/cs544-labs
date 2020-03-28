package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ItemDao;
import edu.mum.domain.Item;


@SuppressWarnings("unchecked")
@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao {
	
	public List<Item> findByCategoryName(String categoryName) {
		 
		Query query = entityManager.createNamedQuery("Item.findByCategoryName");
		return (List<Item>)query.setParameter("categoryName", categoryName).getResultList();
	}


	public ItemDaoImpl() {
		super.setDaoType(Item.class );
		}

 
 }
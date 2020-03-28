package edu.mum.dao;


import java.util.List;

import edu.mum.domain.Item;

public interface ItemDao extends GenericDao<Item> {
	public List<Item> findByCategoryName(String categoryName);
      
}

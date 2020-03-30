package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.BidDao;
import edu.mum.dao.ItemDao;
import edu.mum.domain.Bid;
import edu.mum.domain.Item;


@SuppressWarnings("unchecked")
@Repository
public class BidDaoImpl extends GenericDaoImpl<Bid>implements BidDao {

	public BidDaoImpl() {
		super.setDaoType(Bid.class );
		}

 
 }
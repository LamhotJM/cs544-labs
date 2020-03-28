package edu.mum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class);
	}

	public List<User> findAllJoinFetch() {

		return (List<User>) null;

	}

	public List<User> findAllBatch() {
		List<User> users = (List<User>) this.findAll();

		for (User user : users) {
			if (!user.getBoughtItems().isEmpty())
				user.getBoughtItems().get(0);
		}

		return users;
	}

	@Override
	public List<User> findAllSubSelect() {
		List<User> users = this.findAll();
		users.get(0).getBoughtItems().get(0);

		return users;
	}

}
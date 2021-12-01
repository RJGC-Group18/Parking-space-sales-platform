package com.group18.service;

import java.util.List;

import com.group18.dao.IUserDAO;
import com.group18.po.Client;
import com.group18.po.User;

public class UserService implements IUserService {
	IUserDAO userDAO=null;
	
	public boolean loginInfoCheck(User user) {
		String hql= "from User where username='" + user.getUsername()
		+ "' and password='" + user.getPassword() + "'";
		List list=userDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return false;
		}
		return true;
	}

	public void register(User user) {
		userDAO.save(user);
	}

	public User findByName(User user) {
		String hql= "from User where username='" + user.getUsername()+ "'";
		List list=userDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (User)list.get(0);
	}

	public User findById(User user) {
		String hql= "from User where username='" + String.valueOf(user.getUid())+ "'";
		List list=userDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (User)list.get(0);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}

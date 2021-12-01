package com.group18.service;

import java.util.List;

import com.group18.dao.IUserInformationDAO;
import com.group18.po.ClientInformation;
import com.group18.po.User;
import com.group18.po.UserInformation;

public class UserInformationService implements IUserInformationService {

	IUserInformationDAO userInformationDAO=null;
	
	public void register(UserInformation userInformation) {
		userInformationDAO.save(userInformation);

	}

	public void update(UserInformation userInformation) {
		userInformationDAO.update(userInformation);

	}

	public UserInformation findById(User user) {
		String hql= "from UserInformation where uid='" + String.valueOf(user.getUid())+ "'";
		List list=userInformationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (UserInformation)list.get(0);
	}

	public IUserInformationDAO getUserInformationDAO() {
		return userInformationDAO;
	}

	public void setUserInformationDAO(IUserInformationDAO userInformationDAO) {
		this.userInformationDAO = userInformationDAO;
	}

}

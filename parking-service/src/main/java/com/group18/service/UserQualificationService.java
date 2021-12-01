package com.group18.service;

import java.util.List;

import com.group18.dao.UserQualificationDAO;
import com.group18.po.User;
import com.group18.po.UserQualification;

public class UserQualificationService implements IUserQualificationService {

	UserQualificationDAO userQualificationDAO=null;
	
	public void add(UserQualification userQualification) {
		userQualificationDAO.save(userQualification);

	}

	public void update(UserQualification userQualification) {
		userQualificationDAO.update(userQualification);

	}

	public void delete(UserQualification userQualification) {
		userQualificationDAO.delete(userQualification);

	}

	public List<UserQualification> findByUid(User user) {
		String hql= "from UserQualification where uid='" + String.valueOf(user.getUid())+ "'";
		List list=userQualificationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return list;
	}

	public UserQualification findByQid(UserQualification userQualification) {
		String hql= "from UserQualification where qid='" + String.valueOf(userQualification.getQid())+ "'";
		List list=userQualificationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (UserQualification)list.get(0);
	}

	public UserQualificationDAO getUserQualificationDAO() {
		return userQualificationDAO;
	}

	public void setUserQualificationDAO(UserQualificationDAO userQualificationDAO) {
		this.userQualificationDAO = userQualificationDAO;
	}

}

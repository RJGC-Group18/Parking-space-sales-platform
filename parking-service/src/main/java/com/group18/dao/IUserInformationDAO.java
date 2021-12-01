package com.group18.dao;

import java.util.List;

import com.group18.po.UserInformation;

public interface IUserInformationDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(UserInformation userInformation);//保存销售方信息
	public void update(UserInformation userInformation);//修改销售方信息
}

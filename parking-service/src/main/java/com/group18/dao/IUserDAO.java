package com.group18.dao;

import java.util.List;

import com.group18.po.User;

public interface IUserDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(User user);//保存或修改用户信息
}

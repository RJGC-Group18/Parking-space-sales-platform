package com.group18.dao;

import java.util.List;

import com.group18.po.User;

public interface IUserDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(User user);//保存用户登录信息
	public void update(User user);//修改用户登录信息
}

package com.group18.dao;

import java.util.List;

import com.group18.po.Client;

public interface IClientDAO {
	public List findByHql(String hql);
	public void save(Client client);//保存业主登录信息
	public void update(Client client);//修改业主登录信息
}

package com.group18.dao;

import java.util.List;

import com.group18.po.Client;

public interface IClientDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(Client client);//保存或修改业主信息
}

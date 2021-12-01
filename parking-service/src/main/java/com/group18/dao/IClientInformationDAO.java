package com.group18.dao;

import java.util.List;

import com.group18.po.ClientInformation;

public interface IClientInformationDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(ClientInformation clientInformation);//保存业主信息
	public void update(ClientInformation clientInformation);//修改业主信息
}

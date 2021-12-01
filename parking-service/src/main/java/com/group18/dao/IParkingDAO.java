package com.group18.dao;

import java.util.List;

import com.group18.po.Parking;

public interface IParkingDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(Parking parking);//添加车位信息
	public void update(Parking parking);//修改车位信息
	public void delete(Parking parking);//删除车位信息
}

package com.group18.dao;

import java.util.List;

import com.group18.po.Reservation;

public interface IReservationDAO {
	public List findByHql(String hql);//根据service提供的hql语句进行查询
	public void save(Reservation reservation);//添加车位预约信息
	public void delete(Reservation reservation);//删除车位预约信息
}

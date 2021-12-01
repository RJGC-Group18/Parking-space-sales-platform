package com.group18.service;

import java.util.List;

import com.group18.po.Client;
import com.group18.po.Parking;
import com.group18.po.Reservation;

public interface IReservationService {
	public List<Reservation> findByCid(Client client);//根据业主id查找预约记录
	public List<Reservation> findByPid(Parking parking);//根据车位id查找预约记录
	public void add(Reservation reservation);//添加预约记录
	public void delete(Reservation reservation);//删除预约记录
}

package com.group18.service;

import java.util.List;

import com.group18.dao.DealingDAO;
import com.group18.dao.ReservationDAO;
import com.group18.po.Client;
import com.group18.po.Parking;
import com.group18.po.Reservation;

public class ReservationService implements IReservationService {

	ReservationDAO reservationDAO=null;
	DealingDAO dealingDAO=null;
	
	public List<Reservation> findByCid(Client client) {
		String hql= "from Reservation where cid='" + String.valueOf(client.getCid())+"'";
		List list=reservationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return list;
	}

	public List<Reservation> findByPid(Parking parking) {
		String hql= "from Reservation where pid='" + parking.getPid()+"'";
		System.out.println("pp1");
		List list=reservationDAO.findByHql(hql);
		System.out.println("pp2");
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list;
	}

	public void add(Reservation reservation) {
		reservationDAO.save(reservation);
	}

	public void delete(Reservation reservation) {
		reservationDAO.delete(reservation);
	}

	public Reservation selectReservation(Parking parking)//车位摇号,返回被选中的预约信息
	{
		List<Reservation> reservationList=findByPid(parking);
		if(reservationList==null||reservationList.size()==0)
		{
			return null;
		}
		int selected=(int)(Math.random()*(reservationList.size()));//随机选择
		Reservation reservation=reservationList.get(selected);
		return reservation;
	}
	
	public ReservationDAO getReservationDAO() {
		return reservationDAO;
	}

	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}

}

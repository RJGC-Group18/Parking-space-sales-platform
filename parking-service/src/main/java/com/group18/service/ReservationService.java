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
		List list=reservationDAO.findByHql(hql);
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
		Reservation reservation=null;
		List<Reservation> r=null;
		if(reservationList==null||reservationList.size()==0)
		{
			return null;
		}
		do {
			if(r!=null||r.size()!=0)
			{
				delete(reservation);
				reservationList=findByPid(parking);
			}
			int selected=(int)(Math.random()*(reservationList.size()));//随机选择
			reservation=reservationList.get(selected);
			Client client=new Client();
			client.setCid(reservation.getId().getCid());
			r=findByCid(client);
		}while(r!=null||r.size()!=0);	
		return reservation;
	}
	
	public ReservationDAO getReservationDAO() {
		return reservationDAO;
	}

	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}

}

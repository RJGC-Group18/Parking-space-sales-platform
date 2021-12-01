package com.group18.service;

import java.util.List;

import com.group18.dao.ReservationDAO;
import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Reservation;

public class ReservationService implements IReservationService {

	ReservationDAO reservationDAO=null;
	
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
		String hql= "from Reservation where pid='" + String.valueOf(parking.getPid())+"'";
		List list=reservationDAO.findByHql(hql);
		if(list.isEmpty())
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

	public ReservationDAO getReservationDAO() {
		return reservationDAO;
	}

	public void setReservationDAO(ReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}

}

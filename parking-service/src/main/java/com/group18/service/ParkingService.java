package com.group18.service;

import java.util.Iterator;
import java.util.List;

import com.group18.dao.IDealingDAO;
import com.group18.dao.IParkingDAO;
import com.group18.po.Parking;
import com.group18.po.User;

public class ParkingService implements IParkingService {

	IParkingDAO parkingDAO=null;
	IDealingDAO dealingDAO=null;
	
	public List<Parking> findAll() {
		String hql="from Parking";
		List list=parkingDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		for(Iterator<Parking> it=list.iterator();it.hasNext();)
		{
			Parking p=it.next();
			String hql2="from Dealing where pid='"+p.getPid()+"'";
			List findDealing=dealingDAO.findByHql(hql2);
			if(findDealing!=null)
			{
				it.remove();
			}
		}
		return list;
	}

	public List<Parking> fingByUid(User user) {
		String hql= "from Parking where uid='" + String.valueOf(user.getUid())+"'";
		List list=parkingDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return list;
	}

	public Parking findByPid(Parking parking) {
		String hql= "from Parking where pid='" + String.valueOf(parking.getPid())+"'";
		List list=parkingDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Parking)list.get(0);
	}

	public void add(Parking parking) {
		parkingDAO.save(parking);
	}

	public void update(Parking parking) {
		parkingDAO.update(parking);
	}

	public void delete(Parking parking) {
		parkingDAO.delete(parking);
	}

	public IParkingDAO getParkingDAO() {
		return parkingDAO;
	}

	public void setParkingDAO(IParkingDAO parkingDAO) {
		this.parkingDAO = parkingDAO;
	}

	public IDealingDAO getDealingDAO() {
		return dealingDAO;
	}

	public void setDealingDAO(IDealingDAO dealingDAO) {
		this.dealingDAO = dealingDAO;
	}

}
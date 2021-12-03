package com.group18.service;

import java.util.List;

import com.group18.dao.IDealingDAO;
import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Parking;

public class DealingService implements IDealingService {

	IDealingDAO dealingDAO=null;
	
	public Dealing findByCidAndPid(Client client, Parking parking) {
		String hql= "from Dealing where cid='" + String.valueOf(client.getCid())+
					"' and pid='"+ String.valueOf(parking.getPid())+"'";
		List list=dealingDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Dealing)list.get(0);
	}

	public List<Dealing> findByCid(Client client) {
		String hql= "from Dealing where cid='" + String.valueOf(client.getCid())+"'";
		List list=dealingDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return list;
		}

	public Dealing findByNo(Dealing dealing)
	{
		String hql= "from Dealing where no='" + String.valueOf(dealing.getNo())+"'";
		List list=dealingDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Dealing)list.get(0);
	}
	
	public boolean checkDealing(Dealing dealing) {
		Dealing findDealing=findByNo(dealing);
		if(findDealing.getPay())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void add(Dealing dealing) {
		dealingDAO.save(dealing);
	}

	public void update(Dealing dealing) {
		dealingDAO.update(dealing);
	}

	public void delete(Dealing dealing) {
		dealingDAO.delete(dealing);
	}

	public IDealingDAO getDealingDAO() {
		return dealingDAO;
	}

	public void setDealingDAO(IDealingDAO dealingDAO) {
		this.dealingDAO = dealingDAO;
	}

}

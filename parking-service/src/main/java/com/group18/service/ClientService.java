package com.group18.service;

import java.util.List;

import com.group18.dao.IClientDAO;
import com.group18.po.Client;

public class ClientService implements IClientService {
	IClientDAO clientDAO=null;
	public boolean loginInfoCheck(Client client) {
		String hql= "from Client where username='" + client.getUsername()
				+ "' and password='" + client.getPassword() + "'";
		List list=clientDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return false;
		}
		return true;
	}

	public void register(Client client) {
		clientDAO.save(client);
	}

	public Client findByName(Client client) {
		String hql= "from Client where username='" + client.getUsername()+ "'";
		List list=clientDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Client)list.get(0);
	}

	public Client findById(Client client) {
		String hql= "from Client where username='" + String.valueOf(client.getCid())+ "'";
		List list=clientDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Client)list.get(0);
	}
	
	public IClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

}

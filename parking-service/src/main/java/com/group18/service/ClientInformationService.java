package com.group18.service;

import java.util.List;

import com.group18.dao.IClientInformationDAO;
import com.group18.po.Client;
import com.group18.po.ClientInformation;

public class ClientInformationService implements IClientInformationService {

	IClientInformationDAO clientInformationDAO=null;
	
	public void register(ClientInformation clientInformation) {
		clientInformationDAO.save(clientInformation);
	}

	public void update(ClientInformation clientInformation) {
		clientInformationDAO.update(clientInformation);
	}

	public ClientInformation findById(Client client) {
		String hql= "from ClientInformation where cid='" + String.valueOf(client.getCid())+ "'";
		List list=clientInformationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (ClientInformation)list.get(0);
	}

	public IClientInformationDAO getClientInformationDAO() {
		return clientInformationDAO;
	}

	public void setClientInformationDAO(IClientInformationDAO clientInformationDAO) {
		this.clientInformationDAO = clientInformationDAO;
	}

}

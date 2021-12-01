package com.group18.service;

import java.util.List;

import com.group18.dao.ClientQualificationDAO;
import com.group18.po.Client;
import com.group18.po.ClientInformation;
import com.group18.po.ClientQualification;

public class ClientQualificationService implements IClientQualificationService {

	ClientQualificationDAO clientQualificationDAO=null;
	
	public void add(ClientQualification clientQualification) {
		clientQualificationDAO.save(clientQualification);

	}

	public void update(ClientQualification clientQualification) {
		clientQualificationDAO.update(clientQualification);
	}

	public void delete(ClientQualification clientQualification) {
		clientQualificationDAO.delete(clientQualification);
	}

	public List<ClientQualification> findByCid(Client client) {
		String hql= "from ClientQualification where cid='" + String.valueOf(client.getCid())+ "'";
		List list=clientQualificationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return list;
	}

	public ClientQualification findByQid(ClientQualification clientQualification) {
		String hql= "from ClientQualification where qid='" + String.valueOf(clientQualification.getQid())+ "'";
		List list=clientQualificationDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (ClientQualification)list.get(0);
	}

	public ClientQualificationDAO getClientQualificationDAO() {
		return clientQualificationDAO;
	}

	public void setClientQualificationDAO(ClientQualificationDAO clientQualificationDAO) {
		this.clientQualificationDAO = clientQualificationDAO;
	}

}

package com.group18.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.group18.po.ClientInformation;

public class ClientInformationDAO extends BaseHibernateDAO implements IClientInformationDAO {

	public List findByHql(String hql)
	{
		Session session=null;
		try 
		{
			String queryString = hql;
			session=getSession();
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} 
		catch (RuntimeException re) 
		{
			throw re;
		}
		finally
		{
			session.close();
		}
	}
	
	public void save(ClientInformation clientInformation) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.save(clientInformation);
			tran.commit();
		}
		catch(RuntimeException re)
		{
			if(tran!=null)
			{
				tran.rollback();
			}
			throw re;
		}
		finally
		{
			session.close();
		}
	}

	public void update(ClientInformation clientInformation) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.update(clientInformation);
			tran.commit();
		}
		catch(RuntimeException re)
		{
			if(tran!=null)
			{
				tran.rollback();
			}
			throw re;
		}
		finally
		{
			session.close();
		}
	}

}

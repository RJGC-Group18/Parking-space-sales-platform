package com.group18.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.group18.po.UserInformation;

public class UserInformationDAO extends BaseHibernateDAO implements IUserInformationDAO {

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
	
	public void save(UserInformation userInformation) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.save(userInformation);
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

	public void update(UserInformation userInformation) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.update(userInformation);
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

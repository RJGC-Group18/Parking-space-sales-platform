package com.group18.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import com.group18.po.User;

public class UserDAO extends BaseHibernateDAO implements IUserDAO {

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
	
	public void save(User user) 
	{
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.save(user);
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

	public void update(User user) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.update(user);
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

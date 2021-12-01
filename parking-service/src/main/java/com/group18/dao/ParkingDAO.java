package com.group18.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.group18.po.Parking;

public class ParkingDAO extends BaseHibernateDAO implements IParkingDAO {

	public List findByHql(String hql) {
		try 
		{
			String queryString = hql;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} 
		catch (RuntimeException re) 
		{
			throw re;
		}
	}

	public void save(Parking parking) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.save(parking);
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

	public void update(Parking parking) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.update(parking);
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

	public void delete(Parking parking) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.delete(parking);
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

package com.group18.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.group18.po.Reservation;

public class ReservationDAO extends BaseHibernateDAO implements IReservationDAO {

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

	public void save(Reservation reservation) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.save(reservation);
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

	public void delete(Reservation reservation) {
		Transaction tran=null;
		Session session=null;
		try
		{
			session=getSession();
			tran=session.beginTransaction();
			session.delete(reservation);
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

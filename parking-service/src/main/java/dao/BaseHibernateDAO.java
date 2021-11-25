package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//基础DAO类，用来定义获取session的方法，写DAO务必继承该类
public class BaseHibernateDAO {
	private SessionFactory sessionFactory;
	public Session getSession()
	{
		return sessionFactory.openSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
}

package com.spring.sample.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.Orders;

@Repository("odersDAO")
public class OrdersDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Orders orders) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(orders);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		return false;
	}
}

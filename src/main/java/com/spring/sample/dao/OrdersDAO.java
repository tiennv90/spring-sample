package com.spring.sample.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.Orders;
import com.spring.sample.model.User;

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
	
	public List<Orders> findOrdersByUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "from Orders o WHERE o.user = :user ";
			Query query = session.createQuery(hql);
			query.setParameter("user", user);
			List results = query.list();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;		
	}
}

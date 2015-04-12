package com.spring.sample.dao;

import java.awt.CardLayout;
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
import com.spring.sample.util.Utils;

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
	
	public boolean remove(int orderId) {
		Session session = sessionFactory.openSession();
		Object orders = session.load(Orders.class, orderId);
		Transaction transaction = session.beginTransaction();
		try {
			
			if (orders != null) {
				Query query = session.createQuery("delete Orders o where o.id  = :id");
				query.setParameter("id", orderId);
				 
				int result = query.executeUpdate();
			}
			
			transaction.commit();
			
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

	public Orders findbyId(Integer orderId) {
		
		Session session = sessionFactory.openSession();
		try {
			 return (Orders) session.get(Orders.class, orderId);
		} finally {
			session.close();
		}
	}

	public void update(Orders order) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Orders obj = findbyId(order.getId());
			
			if (obj != null) {
				
				if (order.getCardNumber() != null && !order.getCardNumber().isEmpty()) {
					obj.setCardNumber(order.getCardNumber());
				}
				
				if (order.getCvv() != null && !order.getCvv().isEmpty()) {
					obj.setCvv(order.getCvv());
				}
				
				if (order.getProducts() != null && !order.getProducts().isEmpty()) {
					obj.setProducts(order.getProducts());
				}
				
				session.update(obj);
			}
			
			
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}		
	}
}

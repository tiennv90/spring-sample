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
import com.spring.sample.model.Product;

@Repository("productDAO")
public class ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll(int startIndex, int count) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Product");
			query.setFirstResult(startIndex);
			
			if (count > 0) {
				query.setMaxResults(count);
			}
			
			return query.list();
			
		} finally {
			session.close();
		}

	}
	
	public boolean save(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(product);
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
	
	public boolean update(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(product);
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
	
	public Product findById(int id) {
		
		Session session = sessionFactory.openSession();
		try {
			 return (Product) session.get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
		
	}
	
	public boolean remove(int productId) {
		Session session = sessionFactory.openSession();
		Object product = session.load(Orders.class, productId);
		Transaction transaction = session.beginTransaction();
		try {
			
			if (product != null) {
				Query query = session.createQuery("delete Product p where p.id  = :id");
				query.setParameter("id", productId);
				 
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
	
}

package com.spring.sample.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.Feedback;

@Repository("feedbackDAO")
public class FeedbackDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Feedback feedback) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(feedback);
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
	
	@SuppressWarnings("unchecked")
	public List<Feedback> findAll(int startIndex, int count) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Feedback");
			query.setFirstResult(startIndex);
			
			if (count > 0) {
				query.setMaxResults(count);
			}
			
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			session.close();
		}
		
		return null;
	}
	
}

package com.spring.sample.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.User;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> findAll(int startIndex, int count) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from User");
			query.setFirstResult(startIndex);
			
			if (count > 0) {
				query.setMaxResults(count);
			}
			
			return query.list();
			
		} finally {
			session.close();
		}

	}
	
	public User findById(int id) {
		
		Session session = sessionFactory.openSession();
		try {
			 return (User) session.get(User.class, id);
		} finally {
			session.close();
		}
		
	}
	
	public User findByUserNameAndPassword(String userName, String password) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM User u WHERE E.username = :username and u.password =:password";
			Query query = session.createQuery(hql);
			query.setParameter("username",userName);
			query.setParameter("password", password);
			List results = query.list();
			if (results != null && !results.isEmpty()) {
				return (User) results.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public void update(User User) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User obj = findById(User.getId());
			
			
			session.update(obj);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}
}

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
import com.spring.sample.util.Utils;

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
			String hql = "from User u WHERE u.userName = :username and u.password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("username",userName);
			query.setParameter("password", password);
			List results = query.list();
			if (results != null && !results.isEmpty() && results.size() > 0) {
				return (User) results.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public User findByUserName(String userName) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "from User u WHERE u.userName = :username";
			Query query = session.createQuery(hql);
			query.setParameter("username",userName);
			List results = query.list();
			if (results != null && !results.isEmpty()) {
				return (User) results.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	public boolean update(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User obj = findByUserName(user.getUserName());
			
			obj.setAddress(user.getAddress());
			obj.setFirstName(user.getFirstName());
			obj.setLastName(user.getLastName());
			if (user.getPassword() != null && !user.getPassword().isEmpty()) {
				obj.setPassword(Utils.getHashMD5(user.getPassword()));
			}
			
			session.update(obj);
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
	
	public boolean save(User User) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(User);
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

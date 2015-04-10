package com.spring.sample.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.Category;

@Repository("categoryDAO")
public class CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Category> findAll(int startIndex, int count) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Category");
			query.setFirstResult(startIndex);
			
			if (count > 0) {
				query.setMaxResults(count);
			}
			
			return query.list();
			
		} finally {
			session.close();
		}

	}
	
	public Category findById(int id) {
		
		Session session = sessionFactory.openSession();
		try {
			 return (Category) session.get(Category.class, id);
		} finally {
			session.close();
		}
		
	}	
}

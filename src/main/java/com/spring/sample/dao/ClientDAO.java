package com.spring.sample.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.Client;

@Repository("clientDAO")
public class ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Client> findAll(int startIndex, int count) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Client");
			query.setFirstResult(startIndex);
			
			if (count > 0) {
				query.setMaxResults(count);
			}
			
			return query.list();
			
		} finally {
			session.close();
		}

	}
	
	public Client findById(int id) {
		
		Session session = sessionFactory.openSession();
		try {
			 return (Client) session.get(Client.class, id);
		} finally {
			session.close();
		}
		
	}
	
	public void update(Client client) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Client obj = findById(client.getId());
			
			obj.setJiveId(client.getId());
			obj.setPace(client.getPace());
			obj.setPotential(client.getPotential());
			obj.setPractice(client.getPractice());
			obj.setSalesForceId(client.getSalesForceId());
			obj.setStage(client.getStage());
			
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

package com.spring.sample.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sample.model.Client;

@Repository("clientDAO")
public class ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Client> findAll() {

		Session session = sessionFactory.openSession();
		try {
			
			return session.createQuery("from Client").list();
			
		} finally {
			session.close();
		}

	}
}

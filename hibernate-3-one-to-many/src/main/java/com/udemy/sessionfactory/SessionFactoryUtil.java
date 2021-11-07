package com.udemy.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.entity.Account;
import com.udemy.entity.Customer;

public class SessionFactoryUtil {

	public static SessionFactory getSessionFactory() {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Account.class).buildSessionFactory();
		return sessionFactory;
	}

}

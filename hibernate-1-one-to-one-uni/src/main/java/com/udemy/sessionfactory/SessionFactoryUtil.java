package com.udemy.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.entity.Passport;
import com.udemy.entity.Person;

public class SessionFactoryUtil {

	public static SessionFactory getSessionFactory() {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Passport.class)
				.addAnnotatedClass(Person.class).buildSessionFactory();
		return sessionFactory;
	}

}

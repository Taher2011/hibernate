package com.udemy.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.entity.Student;

public class SessionFactoryUtil {

	public static SessionFactory getSessionFactory() {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}

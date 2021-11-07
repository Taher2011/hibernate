package com.udemy.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.entity.Employee;
import com.udemy.entity.Project;

public class SessionFactoryUtil {

	public static SessionFactory getSessionFactory() {
		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class).buildSessionFactory();
		return sessionFactory;
	}

}

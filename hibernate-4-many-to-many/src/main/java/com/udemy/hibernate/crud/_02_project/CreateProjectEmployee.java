package com.udemy.hibernate.crud._02_project;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Employee;
import com.udemy.entity.Project;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class CreateProjectEmployee {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Project project1 = new Project();
			project1.setName("TechBank");

			Project project2 = new Project();
			project2.setName("RMTech");

			Employee employee1 = new Employee();
			employee1.setName("Rahul");

			project1.addEmployee(employee1);

			session.save(project1);
			session.save(project2);

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

package com.udemy.hibernate.crud._01_employee;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Employee;
import com.udemy.entity.Project;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class CreateEmployeeProject {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Employee employee1 = new Employee();
			employee1.setName("Taher");

			Employee employee2 = new Employee();
			employee2.setName("Mohan");

			Employee employee3 = new Employee();
			employee3.setName("Kunal");

			Employee employee4 = new Employee();
			employee4.setName("Shreya");

			Project project1 = new Project();
			project1.setName("OnlineTax");

			Project project2 = new Project();
			project2.setName("SafeCustody");

			Project project3 = new Project();
			project3.setName("CCW");

			employee1.addProject(project1);
			employee1.addProject(project2);
			employee1.addProject(project3);

			employee2.addProject(project2);
			employee2.addProject(project3);

			employee3.addProject(project3);

			session.persist(employee1);
			session.persist(employee2);
			session.persist(employee3);
			session.persist(employee4);

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

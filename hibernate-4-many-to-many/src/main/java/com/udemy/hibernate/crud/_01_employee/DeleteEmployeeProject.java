package com.udemy.hibernate.crud._01_employee;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Employee;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class DeleteEmployeeProject {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Employee employee1 = session.get(Employee.class, 3);
			if (employee1 != null) {
				session.delete(employee1);
			}

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

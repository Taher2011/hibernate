package com.udemy.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Student;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class GetStudent {

	public static void main(String[] args) {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// start a transaction
			Transaction trx = session.beginTransaction();

			// getting the student object
			Student student = session.get(Student.class, 1);
			System.out.println("Student : " + student);

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

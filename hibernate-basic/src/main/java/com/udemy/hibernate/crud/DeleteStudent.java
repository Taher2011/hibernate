package com.udemy.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Student;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class DeleteStudent {

	public static void main(String[] args) {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// start a transaction
			Transaction trx = session.beginTransaction();

			// getting the student object
			Student student = session.get(Student.class, 3);
			System.out.println("Student : " + student);

			if (student != null) {
				session.delete(student);
				// commit transaction
				trx.commit();

				student = session.get(Student.class, 3);
				System.out.println("Student : " + student);

			}

		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}

package com.udemy.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Student;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class UpdateStudent {

	public static void main(String[] args) {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// start a transaction
			Transaction trx = session.beginTransaction();

			// getting the student object
			Student student = session.get(Student.class, 2);
			System.out.println("Student : " + student);

			if (student != null) {
				// update lastName for student
				student.setLastName("Mishra");
				// commit transaction
				trx.commit();
				
				student = session.get(Student.class, 2);
				System.out.println("Student : " + student);
			}

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

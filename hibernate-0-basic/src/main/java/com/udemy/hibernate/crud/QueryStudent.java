package com.udemy.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Student;
import com.udemy.sessionfactory.SessionFactoryUtil;

/*HQL Query language for getting objects
Similar in nature to SQL where, like, order by, join, in*/

public class QueryStudent {

	public static void main(String[] args) {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// start a transaction
			Transaction trx = session.beginTransaction();

			// getting the student object
			System.out.println("Getting the student");

			List<Student> students = session.createQuery("from Student s").getResultList();
			if (!students.isEmpty()) {
				displayStudent(students);
			}

			System.out.println();

			students = session.createQuery("from Student s where s.firstName = 'Taher'").getResultList();
			if (!students.isEmpty()) {
				displayStudent(students);
			}

			System.out.println();

			students = session.createQuery("from Student s order by s.email").getResultList();
			if (!students.isEmpty()) {
				displayStudent(students);
			}

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

	private static void displayStudent(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}

package com.udemy.hibernate.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Student;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class CreateStudent {

	public static void main(String[] args) {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// create a student object
			Student student1 = new Student("Taher", "Ali", "taher@gmail.com");
			Student student2 = new Student("Amit", "Jain", "amit@gmail.com");
			Student student3 = new Student("Peter", "Tom", "peter@gmail.com");

			List<Student> students = new ArrayList<>();
			students.add(student1);
			students.add(student2);
			students.add(student3);

			// start a transaction
			Transaction trx = session.beginTransaction();

			// save the student object
			for (Student student : students) {
				session.save(student);
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

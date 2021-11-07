package com.udemy.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Student;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class States {

	public static void main(String[] args) {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {
			// create a student object
			Student student1 = new Student("Tushar", "Khanna", "tushar@gmail.com"); // transient state i.e object is
																					// neither
																					// associated with session nor
																					// database.

			// start a transaction
			Transaction trx = session.beginTransaction();

			// save the student object
			session.save(student1); // persistent state i.e. object is associated with session and database both.

			student1.setEmail("tushar@yahoo.com"); // persistent state i.e. object is associated with session and
													// database both.

			// commit transaction
			trx.commit();

			// close session
			session.close(); // detach state i.e. once session is closed object is not associated with
								// session but with database.

			session = sessionFactory.openSession();

			trx = session.beginTransaction();

			Student student2 = session.get(Student.class, 1);

			student2.setEmail("tushar@gmail.com");

			// session.update(student1);
			// Exception occur at line 51 due to, "a 'student2' object with
			// the same identifier i.e. id=1 value was already associated with the session
			// and 'student1' object also have id=1".

			session.update(student2); // detach to persistent state i.e. once session is opened object is associated
										// with session and database.

			session.delete(student2); // removed state i.e object is associated with session but not with database.
			
			// session.update(student1);
			// Exception occur at line 61 due to, "a 'student2' object with
			// the same identifier i.e. id=1 value was already associated with the session
			// and 'student1' object also have id=1".

			trx.commit();

			System.out.println();

		} finally {
			if (session.isOpen()) {
				// close session
				session.close(); // detach state i.e. once session is closed object is not associated with
									// session but with database.
			}
			sessionFactory.close();
		}

	}

}

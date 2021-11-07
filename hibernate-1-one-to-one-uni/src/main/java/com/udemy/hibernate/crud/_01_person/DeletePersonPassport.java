package com.udemy.hibernate.crud._01_person;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Person;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class DeletePersonPassport {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Person person1 = session.get(Person.class, 8);
			System.out.println(person1);

			if (person1 != null) {
				session.delete(person1);
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

package com.udemy.hibernate.crud._01_person;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Person;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class UpdatePersonPassport {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Person person1 = session.get(Person.class, 1);
			System.out.println(person1);

			person1.setCity("London");
			person1.getPassport().setPassportType("Permanent");

			// commit transaction
			trx.commit();

			person1 = session.get(Person.class, 1);
			System.out.println(person1);

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

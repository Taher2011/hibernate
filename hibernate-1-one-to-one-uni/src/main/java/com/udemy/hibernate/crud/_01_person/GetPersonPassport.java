package com.udemy.hibernate.crud._01_person;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Passport;
import com.udemy.entity.Person;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class GetPersonPassport {

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
			
			Passport passport1 = session.get(Passport.class, "543e1f7c-ef31-4a67-9fd0-587eeb12f146");
			System.out.println(passport1);

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

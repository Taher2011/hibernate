package com.udemy.hibernate.crud._02_passport;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Passport;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class GetPassport {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Passport passport1 = session.get(Passport.class, "bfe32153-03a7-426f-8a77-3cb79b7acffe");
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

package com.udemy.hibernate.crud._02_passport;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Passport;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class DeletePassport {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Passport passport1 = session.get(Passport.class, "3cdad3ad-58a1-4bc6-be92-ca0961e29df7");

			if (passport1 != null) {
				session.delete(passport1);
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

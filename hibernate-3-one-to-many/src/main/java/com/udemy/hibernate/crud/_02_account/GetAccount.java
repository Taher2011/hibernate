package com.udemy.hibernate.crud._02_account;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Account;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class GetAccount {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Account account1 = session.get(Account.class, 1);
			System.out.println("Account details are ");
			System.out.println(account1);
			if (account1.getCustomer() != null) {
				System.out.println("Customer details are ");
				System.out.println(account1.getCustomer().getCustomerId() + " " + account1.getCustomer().getName());
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

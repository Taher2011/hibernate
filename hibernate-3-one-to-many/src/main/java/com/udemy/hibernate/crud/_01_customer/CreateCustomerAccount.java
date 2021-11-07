package com.udemy.hibernate.crud._01_customer;

import java.text.ParseException;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Account;
import com.udemy.entity.Customer;
import com.udemy.sessionfactory.SessionFactoryUtil;
import com.udemy.util.DateUtil;

public class CreateCustomerAccount {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Account account1 = new Account();
			account1.setAccountNumber(UUID.randomUUID().toString());
			account1.setType("Savings");
			account1.setCreateOn(DateUtil.parseDate("07-11-2021"));

			Account account2 = new Account();
			account2.setAccountNumber(UUID.randomUUID().toString());
			account2.setType("Current");
			account2.setCreateOn(DateUtil.parseDate("07-12-2021"));

			Account account3 = new Account();
			account3.setAccountNumber(UUID.randomUUID().toString());
			account3.setType("DMat");
			account3.setCreateOn(DateUtil.parseDate("07-10-2021"));

			Customer customer1 = new Customer();
			customer1.setName("Taher Ali");
			customer1.setCity("Indore");
			customer1.setNumber(9898989898L);
			customer1.addAccount(account1);
			customer1.addAccount(account2);
			account1.setCustomer(customer1);
			account2.setCustomer(customer1);

			Customer customer2 = new Customer();
			customer2.setName("Jai Sharma");
			customer2.setCity("Bhopal");
			customer2.setNumber(9898989238L);
			customer2.addAccount(account3);
			account3.setCustomer(customer2);

			session.save(customer1);
			session.save(customer2);

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

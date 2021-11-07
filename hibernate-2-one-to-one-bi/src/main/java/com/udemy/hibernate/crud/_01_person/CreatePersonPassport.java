package com.udemy.hibernate.crud._01_person;

import java.text.ParseException;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Passport;
import com.udemy.entity.Person;
import com.udemy.sessionfactory.SessionFactoryUtil;
import com.udemy.util.DateUtil;

public class CreatePersonPassport {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Passport passport1 = new Passport();
			passport1.setPassportNumber(UUID.randomUUID().toString());
			passport1.setPassportType("LongTerm");
			passport1.setPassportIssueOn(DateUtil.parseDate("07-11-2021"));
			passport1.setPassportValidTo(DateUtil.parseDate("07-11-2026"));

			Passport passport2 = new Passport();
			passport2.setPassportNumber(UUID.randomUUID().toString());
			passport2.setPassportType("Visit");
			passport2.setPassportIssueOn(DateUtil.parseDate("07-09-2020"));
			passport2.setPassportValidTo(DateUtil.parseDate("07-09-2025"));

			Person person1 = new Person();
			person1.setFirstName("Suresh");
			person1.setLastName("Jain");
			person1.setCity("Nagpur");
			person1.setPassport(passport1);

			Person person2 = new Person();
			person2.setFirstName("Nilesh");
			person2.setLastName("Verma");
			person2.setCity("Goa");
			person2.setPassport(passport2);

			session.save(person1);
			session.save(person2);

			// commit transaction
			trx.commit();

		} finally {
			// close session
			session.close();
			sessionFactory.close();
		}

	}

}

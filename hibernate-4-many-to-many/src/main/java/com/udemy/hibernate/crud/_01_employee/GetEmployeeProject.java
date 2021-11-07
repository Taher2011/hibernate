package com.udemy.hibernate.crud._01_employee;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Employee;
import com.udemy.entity.Project;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class GetEmployeeProject {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Employee employee1 = session.get(Employee.class, 4);
			if (employee1 != null) {
				System.out.println("Employee Details are : " + employee1.getEmpId() + " " + employee1.getName());
				if (!employee1.getProjects().isEmpty()) {
					System.out.println("Projects details are : ");
					List<Project> projects = employee1.getProjects();
					for (Project project : projects) {
						System.out.println(project.getProjId() + " " + project.getName());
					}
				}
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

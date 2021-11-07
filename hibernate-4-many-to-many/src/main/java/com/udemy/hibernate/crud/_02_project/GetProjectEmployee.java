package com.udemy.hibernate.crud._02_project;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.udemy.entity.Employee;
import com.udemy.entity.Project;
import com.udemy.sessionfactory.SessionFactoryUtil;

public class GetProjectEmployee {

	public static void main(String[] args) throws ParseException {

		// get session factory
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			Transaction trx = session.beginTransaction();

			Project project1 = session.get(Project.class, 3);
			if (project1 != null) {
				System.out.println("Project Details are : " + project1.getProjId() + " " + project1.getName());
				if (!project1.getEmployees().isEmpty()) {
					System.out.println("Employees details are : ");
					List<Employee> employees = project1.getEmployees();
					for (Employee employee : employees) {
						System.out.println(employee.getEmpId() + " " + employee.getName());
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

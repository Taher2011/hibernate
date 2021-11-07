package com.udemy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb_one_to_one_bi?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "root";

		try {
			System.out.println("Connecting to database: " + url);

			Connection connection = DriverManager.getConnection(url, user, password);

			if (connection != null) {
				System.out.println("Connection successful");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

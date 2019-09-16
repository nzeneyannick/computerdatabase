package com.excilys.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	Connection con;

	private Connexion() {
	}

	/** Instance unique pré-initialisée */
	private static Connexion INSTANCE = new Connexion();

	/** Point d'accès pour l'instance unique du singleton */
	public static Connexion getInstance() {
		return INSTANCE;
	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/computer-database-db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"admincdb", "qwerty1234");
			// Do something with the connection
			System.out.println(" ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.getMessage();

		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}

		return con;
	}

}

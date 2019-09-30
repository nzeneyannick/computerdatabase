package com.excilys.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

public class ConnexionBd {

	// final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	// PropertyConfigurator.configure(Application.class.getClassLoader().getResource("log4j.properties"));

	private ConnexionBd() {

	}

	/** Instance unique pré-initialisée */
	private static ConnexionBd INSTANCE = new ConnexionBd();

	public static ConnexionBd getInstance() {
		return INSTANCE;
	}

	public Connection getConnexionBd() {
		Connection con = null;
		try {

			ResourceBundle r = ResourceBundle.getBundle("db");
			Class.forName(r.getString("NomDriver"));
			con = DriverManager.getConnection(r.getString("url"), r.getString("login"), r.getString("pwd"));

		} catch (Exception e) {
			// LOGGER.error("Impossible de trouver le fichier properties", e);
		}

		return con;
	}

}
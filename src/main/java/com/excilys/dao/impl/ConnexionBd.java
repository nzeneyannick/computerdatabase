package com.excilys.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.application.Application;

public class ConnexionBd {

	Connection con = null;

	// final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	private ConnexionBd() {

	}

	/** Instance unique pré-initialisée */
	private static ConnexionBd INSTANCE = new ConnexionBd();

	public static ConnexionBd getInstance() {
		return INSTANCE;
	}

	public Connection getConnexionBd() {

		try {

			ResourceBundle r = ResourceBundle.getBundle("db");			
			Class.forName(r.getString("NomDriver"));
			con = DriverManager.getConnection(r.getString("url"), r.getString("login"), r.getString("pwd"));			
		
		} catch (Exception e) {
			// LOGGER.error("Impossible de trouver le fichier properties", e);
		}

		return con;
	}

	public void fermer() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Problème de fermeture de la Base de données");
		}
		System.out.println("Base de données Fermée");
	}
}
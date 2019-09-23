package com.excilys.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.application.Application;

public class ConnexionBd {

	Connection con = null;

	final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	private ConnexionBd() {

	}

	/** Instance unique pré-initialisée */
	private static ConnexionBd INSTANCE = new ConnexionBd();

	public static ConnexionBd getInstance() {
		return INSTANCE;
	}

	public Connection getConnexionBd() {

		try {
			FileInputStream fileDb = new FileInputStream("src/com/excilys/properties/db.properties");
			Properties prop = new Properties();
			prop.load(fileDb);

			Class.forName(prop.getProperty("NomDriver"));

			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("login"),
					prop.getProperty("pwd"));

		} catch (FileNotFoundException e) {
			LOGGER.error("Impossible de trouver le fichier properties", e);

		} catch (IOException e) {
			LOGGER.error("erreur lors du chargement du fichier properties");

		} catch (ClassNotFoundException ex) {
			LOGGER.error("Ne peut pas trouver les classes du conducteur de la base de données.");

		} catch (SQLException ex) {
			LOGGER.error("pas de connection a la  base de donnee.");
			ex.printStackTrace();
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
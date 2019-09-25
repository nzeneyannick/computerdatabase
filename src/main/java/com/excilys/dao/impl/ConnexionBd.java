package  main.java.com.excilys.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.excilys.application.Application;



public class ConnexionBd {

	Connection con = null;
	/*ajout bundle*/
	private static ResourceBundle resource = ResourceBundle.getBundle("db");	
    private static String url;
    private static String driver;
    private static String username;
    private static String password;
    /*fin ajout bundle*/
	


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
			//FileInputStream fileDb = new FileInputStream("src/com/excilys/properties/db.properties");
			//FileInputStream fileDb = new FileInputStream("src/db.properties");
			
			
			//FileInputStream fileDb = new FileInputStream("WebContent/resources/db.properties");
			//System.out.println("PATH: " + System.getProperty("user.dir"));
			
			/*bundle commente*/
			//FileInputStream fileDb = new FileInputStream("src/resources/db.properties");
			/*bundle ajoute*/
		    url = resource.getString("url");
		    driver = resource.getString("NomDriver");
		    username = resource.getString("login");
		    password = resource.getString("pwd");
		    /*fin bundle ajoute*/

			
			

			//Properties prop = new Properties();
			
			/*bundle commente*/
			//prop.load(fileDb);
			
			
			//DEBUGGER VOIR CE QU'IL YA DANS LES PROPERTIES
			//Set contenus = prop.keySet();
			//Iterator iter = contenus.iterator();
			//while(iter.hasNext()) {
				//System.out.println("KEY: " + iter.next());
			//}
			//prop.list(arg0);

			//Class.forName(prop.getProperty("NomDriver"));
			Class.forName("driver");
			con = DriverManager.getConnection(url, username, password);
			
			/*bundle commente*/
			//con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("login"),
					//prop.getProperty("pwd"));

		//} catch (FileNotFoundException e) {
			//LOGGER.error("Impossible de trouver le fichier properties", e);
	
		//} catch (IOException e) {
		//	LOGGER.error("erreur lors du chargement du fichier properties");

		} catch (ClassNotFoundException ex) {
			LOGGER.error("Ne peut pas trouver les classes du conducteur de la base de données.", ex);
	
			

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
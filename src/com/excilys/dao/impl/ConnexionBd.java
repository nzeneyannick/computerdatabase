package com.excilys.dao.impl;

import java.sql.*;


public class ConnexionBd {

    Connection          con = null;
    Statement           sta;
    ResultSet           re;

    String NomDriver = "com.mysql.jdbc.Driver";    
    String url = "jdbc:mysql://localhost/computer-database-db";
    String login = "admincdb";
    String pwd = "qwerty1234"; 
    
    private ConnexionBd() {
    	
    }
    /** Instance unique pré-initialisée */
    private static ConnexionBd INSTANCE = new ConnexionBd();
    
    public static ConnexionBd getInstance() {
		return INSTANCE;
	}
    
    public Connection getConnexionBd() {
    	
        try {
            Class.forName(NomDriver);
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("Overture de la connection");
            //sta = con.createStatement();
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Ne peut pas trouver les classes du conducteur de la base de données.");
            System.err.println(ex);
        }
        catch (SQLException ex) {
            System.err.println("pas de connection au base de de donnee.");
            System.err.println(ex);
        }
        
        return con;
     }
  
   
	public void fermer() {
		try {
			re.close();
		} catch (SQLException e) {
			System.out.println("Problème de fermeture de la Base de données");
		}
		System.out.println("Base de données Férmée");
	}
}
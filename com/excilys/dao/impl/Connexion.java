package com.excilys.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.excilys.application.Application;

public class Connexion {

  private Connexion() {}

  /** Instance unique pré-initialisée */
  private static Connexion INSTANCE = new Connexion();

  /** Point d'accès pour l'instance unique du singleton */
  public static Connexion getInstance() {
    return INSTANCE;
  }

  final static Logger logger = LoggerFactory.getLogger(Application.class);

  public Connection getConnection() {
    Properties properties = new Properties();
    Connection con = null;
    FileInputStream fileInputStream = null;

    try {
      fileInputStream = new FileInputStream("src/com/excilys/properties/db.properties");
      properties.load(fileInputStream);

      Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/computer-database-db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
          "admincdb", "qwerty1234");
      con = DriverManager.getConnection(properties.getProperty("DB_URL"),
          properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));
    } catch (IOException e) {
      logger.error("IOException ::" + e);

    } catch (ClassNotFoundException e) {
      logger.error("ClassNotFoundException ::" + e);

    } catch (SQLException e) {
      logger.error("SQLException ::" + e);
    }

    return con;
  }

}

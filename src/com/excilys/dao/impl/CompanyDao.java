package com.excilys.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.excilys.application.Application;
import com.excilys.dao.ICompanyDao;
import com.excilys.entities.Company;

public class CompanyDao implements ICompanyDao {

  Statement statement;
  ResultSet resultset;
  private Connexion connexion;
  private static final String LISTOFCOMPANY = "select id, name from company limit 10;";
  final static Logger logger = LoggerFactory.getLogger(Application.class);

  private CompanyDao() {
    super();
    this.connexion = connexion.getInstance();

  }

  /** Instance unique pré-initialisée */
  private static CompanyDao INSTANCE = new CompanyDao();

  /** Point d'accès pour l'instance unique du singleton */
  public static CompanyDao getInstance() {
    return INSTANCE;
  }

  @Override
  public List<Company> getListCompany() {
    List<Company> list = new ArrayList<Company>();

    try {
      statement = connexion.getConnection().createStatement();
      // execution de la requette
      resultset = statement.executeQuery(LISTOFCOMPANY);
      // recuperation des données
      while (resultset.next()) {
        int id = resultset.getInt("id");
        String name = resultset.getString("name");

        Company company = new Company();
        company.setId(id);
        company.setName(name);

        list.add(company);
      }
    } catch (SQLException e) {

      logger.error("SQEXCEPTION ::" + e);
    }

    finally {
      try {
        if (resultset != null)
          resultset.close();
        if (statement != null)
          statement.close();
        if (connexion.getConnection() != null)
          connexion.getConnection().close();
      } catch (SQLException ignore) {
        logger.error("SQEXCEPTION ::" + ignore);
      }
    }
    return list;
  }
}

package com.excilys.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.ICompanyDao;
import com.excilys.entities.Company;

public class CompanyDao implements ICompanyDao {
	// private Connection con;
	Statement statement;
	ResultSet resultset;
	private Connexion connexion;
	private static final String LISTOFCOMPANY = "select id, name from company limit 10;";

	private CompanyDao() {
		super();
		// getConnection();
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

			e.printStackTrace();
		}

		finally {
			// Fermeture de la connexion
			try {
				if (resultset != null)
					resultset.close();
				if (statement != null)
					statement.close();
				if (connexion.getConnection() != null)
					connexion.getConnection().close();
			} catch (SQLException ignore) {
			}
		}
		return list;
	}
}

package com.excilys.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;
import com.excilys.dao.ICompanyDao;
import com.excilys.entities.Company;

public class CompanyDao implements ICompanyDao {

	private static final String LISTOFCOMPANY = "select id, name from company limit 10;";
	// final static Logger logger = LoggerFactory.getLogger(Application.class);

	private CompanyDao() {

	}

	/** Instance unique pré-initialisée */
	private static CompanyDao INSTANCE = new CompanyDao();

	/** Point d'accès pour l'instance unique du singleton */
	public static CompanyDao getInstance() {
		return INSTANCE;
	}

	public List<Company> getListCompany() {
		List<Company> list = new ArrayList<Company>();

		try {
			ConnexionBd connexion = ConnexionBd.getInstance();
			Statement statement = connexion.getConnexionBd().createStatement();
			ResultSet resultset = statement.executeQuery(LISTOFCOMPANY);
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");

				Company company = new Company();
				company.setId(id);
				company.setName(name);

				list.add(company);
			}
		} catch (SQLException e) {

			// LOGGER.error("SQEXCEPTION ::" + e);
		}

		return list;
	}
}

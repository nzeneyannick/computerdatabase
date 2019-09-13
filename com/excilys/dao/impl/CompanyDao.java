package com.excilys.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.ICompanyDao;
import com.excilys.entities.Company;

public class CompanyDao implements ICompanyDao {
	private Connection con;
	Statement statement;
	ResultSet resultset;
	private static final String LISTOFCOMPANY = "select id, name from company limit 10;";

	public CompanyDao() {
		super();
		getConnection();

	}

	public void getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db ", "admincdb",
					"qwerty1234");
			// Do something with the connection
			System.out.println(" ");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.getMessage();

		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();

		}

	}

	@Override
	public List<Company> getListCompany() {
		List<Company> list = new ArrayList<Company>();

		try {
			statement = con.createStatement();
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
				if (con != null)
					con.close();
			} catch (SQLException ignore) {
			}
		}
		return list;
	}
}

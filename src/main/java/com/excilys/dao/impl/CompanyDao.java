package com.excilys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.ICompanyDao;
import com.excilys.entities.Company;
import com.excilys.utils.DBUtil;


public class CompanyDao implements ICompanyDao {

	private static final String LISTOFCOMPANY = 
			"SELECT "
					+ "id"
					+ ",name"
		+ " FROM"
					+ " company"
					+ " limit 10;";
	
	private static final String FINDBYNAME =""
			+ "SELECT "
					+ "id"
					+ ", name"
			+ " FROM"
					+ " company"
			+ " WHERE"
					+ " name =  ?" ;
	

	private CompanyDao() {

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
			Connection connection = DBUtil.getDataSource().getConnection();
			Statement statement = connection.createStatement();
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

		 e.printStackTrace();
		}

		return list;
	}

	@Override
	public Company findCompanyByName(String nameCompany) {
		Company company = new Company();
		
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);
			
			preparedStatement.setString(1, nameCompany);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");			
				company.setId(id);
				company.setName(name);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return company;
		
		

	}
}

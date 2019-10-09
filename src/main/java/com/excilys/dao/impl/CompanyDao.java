package com.excilys.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.excilys.dao.ICompanyDao;
import com.excilys.entities.Company;
import com.excilys.mapper.CompanyMapper;
import com.excilys.utils.DBUtil;

public class CompanyDao implements ICompanyDao {

	private static final String LISTOFCOMPANY = "SELECT " + "id" + ",name" + " FROM" + " company" + " limit 10;";

	private static final String FINDBYNAME = "" + "SELECT " + "id" + ", name" + " FROM" + " company" + " WHERE"
			+ " name =  ?";

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
		JdbcTemplate vjdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<Company> listCompany = vjdbcTemplate.query(LISTOFCOMPANY, new CompanyMapper());
		return listCompany;
	};

//	@Override
//	public Company findCompanyByName(String nameCompany) {
//		Company company = new Company();
//		
//		
//		try {
//			Connection connection = DBUtil.getDataSource().getConnection();
//			PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);
//			
//			preparedStatement.setString(1, nameCompany);
//			ResultSet resultset = preparedStatement.executeQuery();
//
//			while (resultset.next()) {
//				int id = resultset.getInt("id");
//				String name = resultset.getString("name");			
//				company.setId(id);
//				company.setName(name);
//			}
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//		return company;
//		
//		
//
//	}

	@Override
	public Company findCompanyByName(String nameCompany) {
		JdbcTemplate vjdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		Company company = vjdbcTemplate.queryForObject(FINDBYNAME, new Object[] { new String(nameCompany) },
				new CompanyMapper());
		return company;
	}

}

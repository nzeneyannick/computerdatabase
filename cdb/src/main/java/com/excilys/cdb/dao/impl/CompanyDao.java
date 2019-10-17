package com.excilys.cdb.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.excilys.cdb.dao.ICompanyDao;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.mapper.CompanyMapper;
import com.excilys.cdb.utils.DBUtil;

@Repository
public class CompanyDao implements ICompanyDao {
	

	private static final String LISTOFCOMPANY = "SELECT " + "id" + ",name" + " FROM" + " company" + " limit 10;";

	private static final String FINDBYNAME = "" + "SELECT " + "id" + ", name" + " FROM" + " company" + " WHERE"
			+ " name =  ?";

	

	public List<Company> getListCompany() {
		JdbcTemplate vjdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<Company> listCompany = vjdbcTemplate.query(LISTOFCOMPANY, new CompanyMapper());
		return listCompany;
	};
	
	public Company findCompanyByName(String nameCompany) {
		JdbcTemplate vjdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		Company company = vjdbcTemplate.queryForObject(FINDBYNAME, new Object[] { new String(nameCompany) },
				new CompanyMapper());
		return company;
	}

}

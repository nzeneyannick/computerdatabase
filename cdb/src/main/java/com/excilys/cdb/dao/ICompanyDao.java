package com.excilys.cdb.dao;

import java.util.List;

import com.excilys.cdb.entities.Company;

public interface ICompanyDao {

	public List<Company> getListCompany();

	public Company findCompanyByName(String name);
}

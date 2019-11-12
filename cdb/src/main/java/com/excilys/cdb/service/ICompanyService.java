package com.excilys.cdb.service;

import java.util.List;
import com.excilys.cdb.entities.Company;

public interface ICompanyService {

	public List<Company> getListCompany();

	// public Company findCompanyByName(String nameCompany);

	public Company getCompanyById(int id);

	public void deleteCompany(int id);

}

package com.excilys.cdb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.cdb.dao.ICompanyDao;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.service.ICompagnieService;

@Service
public class CompanyService implements ICompagnieService {
	
	@Autowired
	private ICompanyDao companyDao;

	public List<Company> getListCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany = companyDao.getListCompany();
		return listCompany;
	}

	public Company findCompanyByName(String nameCompany) {	
		Company company = companyDao.findCompanyByName(nameCompany);
		return company;
	}
	public List<Company> afficherListeCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany = companyDao.getListCompany();
		return listCompany;
	}
	

}

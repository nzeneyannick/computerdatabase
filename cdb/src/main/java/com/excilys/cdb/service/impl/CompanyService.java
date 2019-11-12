package com.excilys.cdb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excilys.cdb.dao.ICompanyDao;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	public List<Company> getListCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany = companyDao.getListCompany();
		return listCompany;
	}

	@Override
	public Company getCompanyById(int id) {
		Company company = companyDao.getCompanyById(id);
		return company;
	}

	@Override
	public void deleteCompany(int id) {
		companyDao.deleteCompany(id);

	}

}

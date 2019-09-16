package com.excilys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.entities.Company;
import com.excilys.service.ICompagnieService;

public class CompanyService implements ICompagnieService {

	/**
	 * Implementation de la fonction affichage de la liste des compagnies
	 */
	private CompanyDao companyDao;

	public CompanyService() {
		this.companyDao = CompanyDao.getInstance();
	}

	@Override
	public void getListCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany = companyDao.getListCompany();
		for (Company company : listCompany) {
			System.out.println(company.toString() + " \r");
		}

	}

}

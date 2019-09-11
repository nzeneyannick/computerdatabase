package com.excilys.service.impl;

import java.util.*;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.dao.impl.ComputerDao;
import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.service.ICompagnieService;

public class CompanyService implements ICompagnieService {

	/**
	 * Implemenetation de la fonction affichage de la liste des compagnies
	 */
	@Override
	public void getListCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		CompanyDao companyDao = new CompanyDao();
		listCompany = companyDao.getListCompany();
		for (Company company : listCompany) {
			System.out.println(company.toString() + " \r");
		}

	}

}

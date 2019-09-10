package com.excilys.service;

import java.util.*;

import com.excilys.dao.CompanyDao;
import com.excilys.entities.Company;

public class CompanyService implements ICompagnieService {

	@Override
	public void getListCompany(List<Company> list) {

		for (Company company : list) {
			System.out.println(company.toString() + " \r");
		}

	}

}

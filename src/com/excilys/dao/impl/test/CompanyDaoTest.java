package com.excilys.dao.impl.test;

import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.entities.Company;

import junit.framework.TestCase;

public class CompanyDaoTest extends TestCase{

	CompanyDao companyDao;

	public CompanyDaoTest() {

		companyDao = CompanyDao.getInstance();
	}

	public void testGetlistCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany.addAll(companyDao.getListCompany());
		assertNotNull(listCompany);

	}

}

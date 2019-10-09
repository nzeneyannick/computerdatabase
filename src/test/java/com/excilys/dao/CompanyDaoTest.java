package com.excilys.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.entities.Company;


public class CompanyDaoTest {

	CompanyDao companyDao;

	public CompanyDaoTest() {

		companyDao = CompanyDao.getInstance();
	}

	@Test
	public void testGetlistCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany.addAll(companyDao.getListCompany());
		assertNotNull(listCompany);

	}

}

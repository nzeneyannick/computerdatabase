package com.excilys.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.cdb.dao.impl.CompanyDao;
import com.excilys.cdb.entities.Company;


public class CompanyDaoTest {
	
	@Autowired
	private CompanyDao companyDao;

	@Test
	public void testGetlistCompany() {
		List<Company> listCompany = new ArrayList<Company>();
		listCompany.addAll(companyDao.getListCompany());
		assertNotNull(listCompany);

	}

}

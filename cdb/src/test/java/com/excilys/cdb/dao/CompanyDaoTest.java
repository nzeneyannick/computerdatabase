package com.excilys.cdb.dao;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.cdb.dao.impl.CompanyDao;
import com.excilys.cdb.dto.CompanyDto;


public class CompanyDaoTest {
	
	@Autowired
	private CompanyDao companyDao;

	@Test
	public void testGetlistCompany() {
		List<CompanyDto> listCompany = new ArrayList<>();
		listCompany.addAll(companyDao.getListCompany());
		assertNotNull(listCompany);

	}

}

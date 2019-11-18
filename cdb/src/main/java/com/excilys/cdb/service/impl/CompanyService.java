package com.excilys.cdb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excilys.cdb.dao.ICompanyDao;
import com.excilys.cdb.dto.CompanyDto;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	public List<CompanyDto> getListCompany() {
		List<CompanyDto> listCompany = new ArrayList<>();
		listCompany = companyDao.getListCompany();
		return listCompany;
	}

	@Override
	public CompanyDto getCompanyById(int id) {
		CompanyDto company = companyDao.getCompanyById(id);
		return company;
	}

	@Override
	public void deleteCompany(int id) {
		companyDao.deleteCompany(id);

	}

}

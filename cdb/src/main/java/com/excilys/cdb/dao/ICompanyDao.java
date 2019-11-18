package com.excilys.cdb.dao;

import java.util.List;

import com.excilys.cdb.dto.CompanyDto;

public interface ICompanyDao {

	public List<CompanyDto> getListCompany();

	public CompanyDto getCompanyById(int id);

	public void deleteCompany(int id);
}

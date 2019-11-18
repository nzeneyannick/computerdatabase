package com.excilys.cdb.service;

import java.util.List;
import com.excilys.cdb.dto.CompanyDto;


public interface ICompanyService {

	public List<CompanyDto> getListCompany();

	public CompanyDto getCompanyById(int id);

	public void deleteCompany(int id);

}

package com.excilys.cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excilys.cdb.service.ICompanyService;
import com.excilys.cdb.entities.*;

@RestController
@RequestMapping("/")
public class CompanyControler {
	@Autowired
	private ICompanyService companyService;

	@GetMapping("/companies")
	public List<Company> getAllCompany() {
		List<Company> listCompany = companyService.getListCompany();
		return listCompany;

	}

	@GetMapping("/company/{id}")
	public Company getCompanyById(@PathVariable("id") int id) {
		Company company = companyService.getCompanyById(id);
		return company;
	}

	@DeleteMapping("/company/{id}")
	public void deleteCompany(@PathVariable("id") int id) {
		companyService.deleteCompany(id);

	}

}

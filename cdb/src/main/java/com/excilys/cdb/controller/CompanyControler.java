package com.excilys.cdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excilys.cdb.service.ICompanyService;
import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.excilys.cdb.dto.CompanyDto;

@Api(description="API pour les operrations CRUD sur les companies")
@RestController
@RequestMapping("/companies")
@EnableSwagger2
public class CompanyControler {
	@Autowired
	private ICompanyService companyService;

	@GetMapping()
	public List<CompanyDto> getAllCompany() {
		List<CompanyDto> listCompany = companyService.getListCompany();
		return listCompany;

	}

	@GetMapping("/{id}")
	public CompanyDto getCompanyById(@PathVariable("id") int id) {
		CompanyDto company = companyService.getCompanyById(id);
		return company;
	}

	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable("id") int id) {
		companyService.deleteCompany(id);
	}

}

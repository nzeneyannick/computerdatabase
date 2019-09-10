package com.excilys.application;

import java.util.*;

import com.excilys.dao.CompanyDao;
import com.excilys.service.CompanyService;

public class Application {

	/* La liste qui contiendra tous les résultats de nos essais */
	private List<String> messages = new ArrayList<String>();

	public static void main(String[] args) {

		System.out.print("******Affichage de la liste des compagnies ********\r\r");

		CompanyDao companyDao = new CompanyDao();
		CompanyService companyService = new CompanyService();
		companyService.getListCompany(companyDao.getListCompany());
		System.out.print("\\r\\r******Affichage de la liste des compagnies ********\r\r");
		
		
		
	}

}

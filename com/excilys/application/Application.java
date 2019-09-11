package com.excilys.application;

import java.util.*;

import com.excilys.dao.CompanyDao;
import com.excilys.dao.ComputerDao;
import com.excilys.service.CompanyService;
import com.excilys.service.ComputerService;

public class Application {

	/* La liste qui contiendra tous les résultats de nos essais */
	private List<String> messages = new ArrayList<String>();

	public static void main(String[] args) {

		System.out.print("******Affichage de la liste des compagnies ********\r");
		CompanyDao companyDao = new CompanyDao();
		CompanyService companyService = new CompanyService();
		companyService.getListCompany(companyDao.getListCompany());

		System.out.print("\f\r******Affichage de la liste des computers ********\r");
		ComputerDao computerDao = new ComputerDao();
		ComputerService computerService = new ComputerService();
		computerService.getListComputer(computerDao.getListComputer());

	}

}

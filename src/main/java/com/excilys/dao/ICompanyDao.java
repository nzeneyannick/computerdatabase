package com.excilys.dao;

import java.util.List;

import com.excilys.entities.Company;





public interface ICompanyDao {
	/**
	 * 
	 * Fonction retournant la Liste des compagnies en base
	 */
	public List<Company> getListCompany();
	
	/**
	 * 
	 * Fonction permettant de rechercher un company selon le nom
	 */
	public Company findCompanyByName(String name);
	
	
}



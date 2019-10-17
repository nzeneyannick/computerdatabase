package com.excilys.cdb.service;

import java.util.List;

import com.excilys.cdb.entities.Company;





public interface ICompagnieService {
	/**
	 *  Affichage de la liste des compagnies
	 * 
	 */
	public List<Company>  getListCompany() ;
	
	public Company findCompanyByName(String nameCompany) ;
	


}

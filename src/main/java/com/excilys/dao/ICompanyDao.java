package main.java.com.excilys.dao;

import java.util.*;

import main.java.com.excilys.entities.Company;



public interface ICompanyDao {
	/**
	 * 
	 * Fonction retournant la Liste des compagnies en base
	 */
	public List<Company> getListCompany();
}

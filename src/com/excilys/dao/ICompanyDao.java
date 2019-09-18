package com.excilys.dao;

import java.util.*;

import com.excilys.entities.Company;
import com.excilys.entities.Computer;

public interface ICompanyDao {
	/**
	 * 
	 * Fonction retournant la Liste des compagnies en base
	 */
	public List<Company> getListCompany();
}

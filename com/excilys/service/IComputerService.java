package com.excilys.service;

import java.util.List;

import com.excilys.entities.Company;
import com.excilys.entities.Computer;

public interface IComputerService {
	/**
	 * Affichage de la liste des computers
	 */
	public void getListComputer();

	/**
	 * Creation d'un computer
	 */
	public void createComputer(Computer computer);
	/**
	 * Afficher les details d'un computer
	 */
	public void showComputerDetail(int idComputer);
	
	
	/**
	 * Suppression d'un computer
	 */
	public void deleteComputer(int id);
	
	

}

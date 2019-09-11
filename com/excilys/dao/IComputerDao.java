package com.excilys.dao;

import com.excilys.entities.Computer;
import java.util.*;

public interface IComputerDao {
	/**
	 * Fonction retournaNt la liste des computers en base
	 */
	public List<Computer> getListComputer();

	/**
	 * Fonction permettant de creer un computer
	 */
	public void createComputer(Computer computer);
	/**
	 * Fonction permettant d'afficher les details d'un computer
	 */
	public Computer showComputerDetail(int id);
	/**
	 * Suppression d'un computer
	 */
	public void deleteComputer(int id);
}

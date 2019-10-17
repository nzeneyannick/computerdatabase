package com.excilys.cdb.dao;

import java.util.List;
import java.util.Optional;

import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;



public interface IComputerDao {
	/**
	 * Fonction retournaNt la liste des computers en base
	 */
	public List<Computer> getListComputer();

	/**
	 * Fonction permettant de creer un computer
	 */
	public void createComputer(ComputerDto computerDto);

	/**
	 * Fonction permettant d'afficher les details d'un computer
	 */
	public Optional<Computer> showComputerDetail(int id);

	/**
	 * Suppression d'un computer
	 */
	public void deleteComputer(int id);

	/**
	 * Fonction mise à jour d'un computer
	 */
	public void updateComputer(ComputerDto computerDto);
	
	
	/**
	 * fonction de recherche par nom
	 * */
	public List<Computer> findByName(String name);
}

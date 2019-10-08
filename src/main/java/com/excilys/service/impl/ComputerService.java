package com.excilys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.excilys.dao.impl.ComputerDao;
import com.excilys.dto.ComputerDto;
import com.excilys.entities.Computer;
import com.excilys.service.IComputerService;

public class ComputerService implements IComputerService {

	ComputerDao computerDao;
	// final static Logger logger = LoggerFactory.getLogger(ComputerService.class);

	private ComputerService() {
		computerDao = ComputerDao.getInstance();
	}

	/** Instance unique pré-initialisée */
	private static ComputerService INSTANCE;

	public static ComputerService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComputerService();
		}
		return INSTANCE;
	}

	/**
	 * Implemenetation de la fonction affichage de la liste des computers
	 */
	@Override
	public List<Computer> getListComputer() {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerDao.getListComputer();
		return listComputer;
	}

	/**
	 * Implementation de la fonction creation d'un computer
	 */
	@Override
	public void createComputer(ComputerDto computerDto) {
		computerDao.createComputer(computerDto);
	}

	/**
	 * Implementation de la fonction delete computer
	 */
	@Override
	public void deleteComputer(int id) {
		computerDao.deleteComputer(id);

	}

	/**
	 * Implementation de la fonction show details computer
	 */
	@Override
	public Optional<Computer> showComputerDetail(int idComputer) {

		Optional<Computer> computer = computerDao.showComputerDetail(idComputer);

		return computer;
	}

	@Override
	public void updateComputer(ComputerDto computerDto) {
		computerDao.updateComputer(computerDto);
	}

	@Override
	public List<Computer> findByName(String nameComputer) {

		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerDao.findByName(nameComputer);
		
		return listComputer;
	}

}

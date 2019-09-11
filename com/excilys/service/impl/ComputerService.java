package com.excilys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.impl.ComputerDao;
import com.excilys.entities.Computer;
import com.excilys.service.IComputerService;

public class ComputerService implements IComputerService {

	/**
	 * Implemenetation de la fonction affichage de la liste des computers
	 */
	@Override
	public void getListComputer() {
		List<Computer> listComputer = new ArrayList<Computer>();
		ComputerDao computerDao = new ComputerDao();
		listComputer = computerDao.getListComputer();

		for (Computer computer : listComputer) {
			System.out.println(computer.toString());
		}

	}

	/**
	 * Implementation de la fonction creation d'un computer
	 */
	@Override
	public void createComputer(Computer computer) {
		ComputerDao computerDao = new ComputerDao();
		computerDao.createComputer(computer);
		System.out.println("Computer créé avec sucess \n" + computer.toString());
	}

	@Override
	public void deleteComputer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showComputerDetail(int idComputer) {
		ComputerDao computerDao = new ComputerDao();
		Computer computer = computerDao.showComputerDetail(idComputer);
		// computer = computerDao.showComputerDetail(idComputer);
		System.out.println(computer.toString());

	}

}

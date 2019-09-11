package com.excilys.service.impl;

import java.util.List;

import com.excilys.entities.Computer;
import com.excilys.service.IComputerService;

public class ComputerService implements IComputerService{
	
/**
 * Implemenetation de la fonction affichage de la liste des computers 
 */
	@Override
	public void getListComputer(List<Computer> list) {
		for(Computer computer : list) {
			System.out.println(computer.toString());
		}
		
	}

}

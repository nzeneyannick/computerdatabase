package com.excilys.cdb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excilys.cdb.dao.impl.ComputerDao;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.service.IComputerService;

@Service
public class ComputerService implements IComputerService {

	@Autowired
	private ComputerDao computerDao;

	public List<Computer> getListComputer() {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerDao.getListComputer();
		return listComputer;
	}


	public void createComputer(ComputerDto computerDto) {
		computerDao.createComputer(computerDto);
	}

	public void deleteComputer(int id) {
		computerDao.deleteComputer(id);
	}

	public Optional<Computer> showComputerDetail(int idComputer) {
		Optional<Computer> computer = computerDao.showComputerDetail(idComputer);
		return computer;
	}

	public void updateComputer(ComputerDto computerDto) {
		computerDao.updateComputer(computerDto);
	}

	public List<Computer> findByName(String nameComputer) {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerDao.findByName(nameComputer);
		return listComputer;
	}

}

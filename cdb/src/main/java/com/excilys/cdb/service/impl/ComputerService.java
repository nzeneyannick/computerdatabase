package com.excilys.cdb.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excilys.cdb.dao.IComputerDao;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.service.IComputerService;

@Service
public class ComputerService implements IComputerService {

	@Autowired
	private IComputerDao computerDao;

	public List<ComputerDto> getListComputer() {

		return computerDao.getListComputer();
	}

	public int createComputer(ComputerDto computerDto) {
		computerDao.createComputer(computerDto);
		return computerDto.getId();
	}

	public void deleteComputer(int id) {
		computerDao.deleteComputer(id);
	}

	public void updateComputer(int id,ComputerDto computerDto) {
		computerDao.updateComputer(id, computerDto);
	}


	public ComputerDto getComputerById(int id) {
		return computerDao.getComputerById(id);
	}

}

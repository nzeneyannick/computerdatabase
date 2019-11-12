package com.excilys.cdb.service;

import java.util.List;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;

public interface IComputerService {

	public List<Computer> getListComputer();

	public int createComputer(ComputerDto computerDto);

	public void deleteComputer(int id);

	public void updateComputer(int id, ComputerDto computerDto);

	public Computer getComputerById(int id);

}

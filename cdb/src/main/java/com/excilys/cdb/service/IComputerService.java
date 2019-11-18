package com.excilys.cdb.service;

import java.util.List;
import com.excilys.cdb.dto.ComputerDto;


public interface IComputerService {

	public List<ComputerDto> getListComputer();

	public int createComputer(ComputerDto computerDto);

	public void deleteComputer(int id);

	public void updateComputer(int id, ComputerDto computerDto);

	public ComputerDto getComputerById(int id);

}

package com.excilys.cdb.dao;

import java.util.List;

import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;

public interface IComputerDao {
	
	public List<ComputerDto> getListComputer();

	
	public int createComputer(ComputerDto computerDto);


	public void deleteComputer(int id);


	public void updateComputer(int id, ComputerDto computerDto);
		
	
	public ComputerDto getComputerById(int id) ;
		
}

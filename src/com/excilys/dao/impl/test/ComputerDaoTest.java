package com.excilys.dao.impl.test;


import java.util.ArrayList;
import java.util.List;

import com.excilys.dao.impl.ComputerDao;
import com.excilys.entities.Computer;

import junit.framework.TestCase;

public class ComputerDaoTest extends TestCase {
	ComputerDao computerDao;

	public ComputerDaoTest() {
		computerDao = ComputerDao.getInstance();
	}
	public void testGetListComputer() {
		List<Computer>listComputer = new ArrayList<Computer>();
		listComputer.addAll(computerDao.getListComputer());
		assertNotNull(listComputer);
		
		
	}
	public void testshowComputerDetail() {
		
		int testId= 575;
		Computer computer = new Computer();
		computer = computerDao.showComputerDetail(testId);		
		assertEquals(testId,computer.getId());	
		
		
	}
	
	
	
	

}

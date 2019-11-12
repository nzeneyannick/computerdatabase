
package com.excilys.cdb.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.dao.impl.ComputerDao;


public class ComputerDaoTest {
	@Autowired
	private ComputerDao computerDao;	

	@Test
	public void testGetListComputer() {
		List<Computer> listComputer = new ArrayList<>();
		listComputer.addAll(computerDao.getListComputer());
		assertNotNull(listComputer);

	}

	@Test
	public void testshowComputerDetail() {

		int testId = 575;
		
		Computer computer = computerDao.getComputerById(testId);
		
		//assertEquals(true, computer.isPresent());
		
		assertEquals(testId, computer.getId());

	}

}

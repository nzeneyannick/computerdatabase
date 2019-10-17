
package com.excilys.cdb.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.excilys.cdb.dao.impl.ComputerDao;
import com.excilys.cdb.entities.Computer;

public class ComputerDaoTest {
	@Autowired
	private ComputerDao computerDao;	

	@Test
	public void testGetListComputer() {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer.addAll(computerDao.getListComputer());
		assertNotNull(listComputer);

	}

	@Test
	public void testshowComputerDetail() {

		int testId = 575;
		
		Optional<Computer> computer = computerDao.showComputerDetail(testId);
		
		assertEquals(true, computer.isPresent());
		
		Computer comp  = computer.get();
		assertEquals(testId, comp.getId());

	}

}

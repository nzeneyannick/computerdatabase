
package com.excilys.cdb.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.dao.impl.ComputerDao;
import com.excilys.cdb.dto.ComputerDto;


public class ComputerDaoTest {
	@Autowired
	private ComputerDao computerDao;	

	@Test
	public void testGetListComputer() {
		List<ComputerDto> listComputer = new ArrayList<>();
		listComputer.addAll(computerDao.getListComputer());
		assertNotNull(listComputer);

	}

	@Test
	public void testshowComputerDetail() {

		int testId = 575;		
		ComputerDto computer = computerDao.getComputerById(testId);		
		assertEquals(testId, computer.getId());

	}

}

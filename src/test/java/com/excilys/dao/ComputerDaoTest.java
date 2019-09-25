package test.java.com.excilys.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.com.excilys.dao.impl.ComputerDao;
import main.java.com.excilys.entities.Computer;



public class ComputerDaoTest {
	ComputerDao computerDao;

	public ComputerDaoTest() {
		computerDao = ComputerDao.getInstance();
	}

	@Test
	public void testGetListComputer() {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer.addAll(computerDao.getListComputer());
		assertNotNull(listComputer);

	}

	@Test
	public void testshowComputerDetail() {

		int testId = 575;
		Computer computer = new Computer();
		computer = computerDao.showComputerDetail(testId);
		assertEquals(testId, computer.getId());

	}

}

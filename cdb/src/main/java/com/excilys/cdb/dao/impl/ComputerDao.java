package com.excilys.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.excilys.cdb.dao.IComputerDao;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.mapper.ComputerMapper;

@Transactional
@Repository
public class ComputerDao implements IComputerDao {

	public final Logger LOG = Logger.getLogger(ComputerDao.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	ComputerMapper computerMapper;

	private static final String QUERY_LIST_OF_COMPUTER = "from Computer as cpt ORDER BY cpt.id,cpt.name";
	private static final String QUERY_FIND_COMPUTER_BY_ID = "FROM Computer where id = :id";
	private static final String QUERY_DELETE_ID_COMPUTER = "DELETE FROM Computer WHERE  id =:id";
	private static final String QUERY_UPDATE_COMPUTER_BY_ID = "UPDATE Computer set name = :name, introduced = :introduced, discontinued = :discontinued, company_id = :company_id where id =:id";
	private static final String QUERY_FIND_BY_NAME = "from Computer  WHERE  name like :name";

	/**************************************************************/
	public List<Computer> getListComputer() {
		List<Computer> listComputer = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query<Computer> query = session.createQuery(QUERY_LIST_OF_COMPUTER);
		listComputer = query.list();
		return listComputer;
	}

	public Computer getComputerById(int id) {
		Computer computer = new Computer();
		Session session = sessionFactory.getCurrentSession();
		Query<Computer> query = session.createQuery(QUERY_FIND_COMPUTER_BY_ID);
		query.setParameter("id", id);
		List results = query.getResultList();
		if (results != null && !results.isEmpty()) {
			computer = (Computer) results.get(0);
			//transformer le computer en computerDto pr retourner le bon format de date
		}

		return computer;
	}

	public void deleteComputer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Computer> query = session.createQuery(QUERY_DELETE_ID_COMPUTER);
		query.setParameter("id", id);
		query.executeUpdate();

	}

	public int createComputer(ComputerDto computerDto) {
		Computer computer = computerMapper.convertToComputer(computerDto);
		Session session = sessionFactory.getCurrentSession();
		session.save(computer);
		return computer.getId();
	}

	public void updateComputer(int id, ComputerDto computerDto) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Computer computer = computerMapper.convertToComputer(computerDto);
			Query<Computer> query = session.createQuery(QUERY_UPDATE_COMPUTER_BY_ID);
			query.setParameter("name", computer.getName());
			query.setParameter("introduced", computer.getIntroduced());
			query.setParameter("discontinued", computer.getDiscontinued());
			query.setParameter("company_id", computer.getCompany().getId());
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (HibernateException h) {
			LOG.error(h);
		}
	}

	





}

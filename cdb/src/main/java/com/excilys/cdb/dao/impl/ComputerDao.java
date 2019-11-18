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

	private static final String QUERY_LIST_OF_COMPUTER = "from Computer as cpt ORDER BY cpt.id,cpt.name";
	private static final String QUERY_FIND_COMPUTER_BY_ID = "FROM Computer where id = :id";
	private static final String QUERY_DELETE_ID_COMPUTER = "DELETE FROM Computer WHERE  id =:id";
	private static final String QUERY_UPDATE_COMPUTER_BY_ID = "UPDATE Computer set name = :name, introduced = :introduced, discontinued = :discontinued, company_id = :company_id where id =:id";

	public final Logger LOG = Logger.getLogger(ComputerDao.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	ComputerMapper computerMapper;

//	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//	Validator validator = factory.getValidator();

	@SuppressWarnings("unchecked")
	public List<ComputerDto> getListComputer() {
		List<ComputerDto> listComputerDto = new ArrayList<>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Computer> query = session.createQuery(QUERY_LIST_OF_COMPUTER);
			List<Computer> listComputer = query.list();
			for (Computer computer : listComputer) {
				listComputerDto.add(computerMapper.convertToComputerDto(computer));
			}

		} catch (HibernateException e) {
			LOG.error(e);
		}
		return listComputerDto;
	}

	@SuppressWarnings("unchecked")
	public ComputerDto getComputerById(int id) {

		ComputerDto computerDto = new ComputerDto();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Computer> query = session.createQuery(QUERY_FIND_COMPUTER_BY_ID);
			query.setParameter("id", id);
			List<Computer> results = query.getResultList();
			if (results != null && !results.isEmpty()) {
				Computer computer = (Computer) results.get(0);
				computerDto = computerMapper.convertToComputerDto(computer);

			}
		} catch (HibernateException e) {
			LOG.error(e);
		}
		return computerDto;
	}

	@SuppressWarnings("unchecked")
	public void deleteComputer(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Computer> query = session.createQuery(QUERY_DELETE_ID_COMPUTER);
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (HibernateException e) {
			LOG.error(e);
		}

	}

	public int createComputer(ComputerDto computerDto) {
		Computer computer = computerMapper.convertToComputer(computerDto);

		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(computer);

		} catch (HibernateException e) {
			LOG.error(e);
		}
		return computer.getId();

	}

	@SuppressWarnings("unchecked")
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

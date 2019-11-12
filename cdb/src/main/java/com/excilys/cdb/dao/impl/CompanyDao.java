package com.excilys.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.excilys.cdb.dao.ICompanyDao;
import com.excilys.cdb.entities.Company;

//@Transactional
@Repository
public class CompanyDao implements ICompanyDao {
	@Autowired
	private SessionFactory sessionFactory;
	public final Logger LOG = Logger.getLogger(CompanyDao.class);
	private static final String QUERY_LIST_OF_COMPANY = "from Company";
	private static final String QUERY_FIND_BY_NAME = "from Company  WHERE name =:name";

	@SuppressWarnings("unchecked")
	public List<Company> getListCompany() {
		List<Company> listCompany = new ArrayList<>();		
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(QUERY_LIST_OF_COMPANY);
		listCompany =(List<Company>) query.list();
		return listCompany;

	};

	public Company findCompanyByName(String nameCompany) {
		Company company = new Company();

		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Company> query = session.createQuery(QUERY_FIND_BY_NAME);
			query.setParameter("name", nameCompany);
			company = (Company) query.uniqueResult();
		} catch (HibernateException h) {
			LOG.error(h);
		}
		return company;

	}

}

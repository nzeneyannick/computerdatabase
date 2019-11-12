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

@Transactional
@Repository
public class CompanyDao implements ICompanyDao {
	@Autowired
	private SessionFactory sessionFactory;
	public final Logger LOG = Logger.getLogger(CompanyDao.class);
	private static final String QUERY_FIND_COMPANY_BY_ID = "FROM Company where id = :id";
	private static final String QUERY_LIST_OF_COMPANY = "from Company as cpn ORDER BY cpn.id,cpn.name";
	private static final String QUERY_DELETE_ID_COMPANY = "DELETE FROM Company WHERE  id = :id";

	@SuppressWarnings("unchecked")
	public List<Company> getListCompany() {
		List<Company> listCompany = new ArrayList<>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Company> query = session.createQuery(QUERY_LIST_OF_COMPANY);
			listCompany = query.list();
		} catch (HibernateException e) {
			LOG.error(e);
		}
		return listCompany;
	}

	@SuppressWarnings("unchecked")
	public Company getCompanyById(int id) {
		Company company = new Company();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Company> query = session.createQuery(QUERY_FIND_COMPANY_BY_ID);
			query.setParameter("id", id);
			List<Company> results = query.getResultList();
			if (results != null && !results.isEmpty()) {
				company = (Company) results.get(0);
			}
		} catch (HibernateException e) {
			LOG.error(e);
		}
		return company;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteCompany(int id) {

		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Company> query = session.createQuery(QUERY_DELETE_ID_COMPANY);
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (HibernateException e) {
			LOG.error(e);
		}

	}

}

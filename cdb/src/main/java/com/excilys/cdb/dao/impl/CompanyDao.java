package com.excilys.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import com.excilys.cdb.dao.ICompanyDao;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.utils.HibernateUtil;

@Repository
public class CompanyDao implements ICompanyDao {
	
	public final Logger LOG = Logger.getLogger(CompanyDao.class);
	private static final String QUERY_LIST_OF_COMPANY = "from company";
	private static final String QUERY_FIND_BY_NAME = "from company  WHERE name =:name";

	public List<Company> getListCompany() {
		List<Company> listCompany=null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(QUERY_LIST_OF_COMPANY);				
			listCompany = query.list();
		} catch (HibernateException h) {
			LOG.error(h);
		}

		return listCompany;

	};

	public Company findCompanyByName(String nameCompany) {
		Company company = null;
	
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();;
			Query query = session.createQuery(QUERY_FIND_BY_NAME);			
			query.setParameter("name", nameCompany);
			company = (Company) query.uniqueResult();
		} catch (HibernateException h) {
			LOG.error(h);
		}
		return company;

	}

}

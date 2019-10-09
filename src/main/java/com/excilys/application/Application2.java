package com.excilys.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.entities.Company;

public class Application2 {

	public static void main(String[] args) {

	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      CompanyDao companyDao = (CompanyDao)context.getBean("CompanyDao");
	      
	      System.out.println("------Listing Multiple Records--------" );
	      List<Company> listCompany = companyDao.getListCompany();
	      
	      for (Company company : listCompany) {
		         System.out.print("ID : " + company.getId()  );
		         System.out.print(", Name : " + company.getName() +"\n");		        
		      } 
	}

}

package com.excilys.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excilys.entities.Company;
import com.excilys.service.impl.CompanyService;

public class Application2 {

	public static void main(String[] args) {

	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      
	     // CompanyDao companyDao = (CompanyDao)context.getBean("CompanyDao");
	      CompanyService companyService = (CompanyService)context.getBean("CompanyService");
	      
	      
	      System.out.println("------Listing Company--------" );
	      List<Company> listCompany  = companyService.getListCompany();
	      
	      //List<Company> listCompany = companyDao.getListCompany();
	      
	      for (Company company : listCompany) {
		         System.out.print("ID : " + company.getId()  );
		         System.out.print(", Name : " + company.getName() +"\n");		        
		      } 
	      System.out.println("------Affichage  Company --------" );
	      String name = "Cray";
	      Company company = companyService.findCompanyByName(name);
	      System.out.println(company.toString());
	}

}

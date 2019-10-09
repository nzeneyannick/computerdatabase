package com.excilys.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;

public class Application2 {

	public static void main(String[] args) {

	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");	   
	      CompanyService companyService = (CompanyService)context.getBean("CompanyService");	
	      ComputerService computerService = (ComputerService)context.getBean("ComputerService");
	      
	      
	      System.out.println("------Listing Company--------" );
	      List<Company> listCompany  = companyService.getListCompany();	      
	         
	      for (Company company : listCompany) {
		         System.out.print("ID : " + company.getId()  );
		         System.out.print(", Name : " + company.getName() +"\n");		        
		      } 
	      System.out.println("------Affichage  Company --------" );
	      String name = "Cray";
	      Company company = companyService.findCompanyByName(name);
	      System.out.println(company.toString());
	      
	      System.out.println("------Affichage  Computer --------" );
	      List<Computer> listComputer = computerService.getListComputer();
	      for (Computer computer : listComputer) {
		         
		         System.out.print(", Name : " + computer.toString() +"\n");		        
		      } 
	      
	      
	      
	      
	}

}

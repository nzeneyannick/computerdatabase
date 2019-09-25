package main.java.com.excilys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.excilys.entities.Company;
import main.java.com.excilys.entities.Computer;
import main.java.com.excilys.service.impl.CompanyService;
import main.java.com.excilys.service.impl.ComputerService;



//@WebServlet ( "/getListComputers")
@WebServlet ( "/views/dasboard")
public class dashboard extends HttpServlet {
	//public static final String VUE = "/WEB-INF/getListComputers.jsp";
	//public static final String VUE = "/WEB-INF/dashboard.jsp";
	//public static final String VUE = "/views/dashboard.html";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ConnexionBd connecBd = ConnexionBd.getInstance();
		//Connection conn = null;
		//conn = (Connection) connecBd.getConnexionBd();
		
		
		
		  //CompanyService companyService = CompanyService.getInstance();
		//CompanyDao c = CompanyDao.getInstance();
		
		//List<Company> listCompany = companyService.getListCompany();
		
		//List<Company> listCompany = new ArrayList<Company>();		
		//listCompany = c.getListCompany();
		
		// test qui marche
		/*List<String> listComputer = new ArrayList<String>();
		listComputer.add("stringtest1");
		listComputer.add("stringtest2");
		listComputer.add("stringtest3");*/
		
		
		//ComputerService c = ComputerService.getInstance();
		///Computer Computer = new Computer();
		
		//Computer = c.showComputerDetail(575);
		
		
		
		
		
		
		
		// renvoyer un liste de computer avec le service pour le recuperer dals la servlet
		
		//request.setAttribute("listComputer", Computer);		
		//request.setAttribute("computer", Computer);	
		//this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}

package com.excilys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.dao.impl.ComputerDao;
import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;

@WebServlet("/views")
public class dashboard extends HttpServlet {

	public static final String VUE = "/views/dashboard.jsp";
	 //public static final String VUE = "/views.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ComputerService computerService = ComputerService.getInstance();		

		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerService.getListComputer();
		int sumComputer =listComputer.size();
		

		request.setAttribute("listComputer", listComputer);
		request.setAttribute("sumComputer", sumComputer);

		request.getRequestDispatcher(VUE).forward(request, response);
	}

}

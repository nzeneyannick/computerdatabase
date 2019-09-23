package com.excilys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.entities.Computer;
import com.excilys.service.impl.ComputerService;

public class ListComputers extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ComputerService computerService = ComputerService.getInstance();
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerService.getListComputer();
		request.setAttribute("listComputer", listComputer);

		// String message = "Transmission de variables : OK !";
		// request.setAttribute( "test", message );
		// this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward(
		// request, response );
		this.getServletContext().getRequestDispatcher("WEB-INF/getListComputers.jsp").forward(request, response);
	}

}

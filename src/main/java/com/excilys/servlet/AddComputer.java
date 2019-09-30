package com.excilys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.service.impl.ComputerService;

@WebServlet("/addComputer")
//@WebServlet("views")
public class AddComputer extends HttpServlet {

	public static final String VUE = "/views/addComputer.jsp";

	public static final String CHAMP_NAME = "nameComputer";
	public static final String CHAMP_CONTINUED = "CONTINUED";
	public static final String CHAMP_DISCONTINUED = "DISCONTINUED";
	public static final String CHAMP_IDCOMPANY = "-1";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter(CHAMP_NAME);
		String continued = request.getParameter(CHAMP_CONTINUED);
		String discontinued = request.getParameter(CHAMP_DISCONTINUED);
		//int idCompany = Integer.parseInt(request.getParameter(CHAMP_IDCOMPANY));
		String idCompany = request.getParameter(CHAMP_IDCOMPANY);

		//ComputerDto computerDto = new ComputerDto();
		//CompanyDto companyDto = new CompanyDto();
		//companyDto.setIdDto(idCompany);

		//computerDto.setNameDto(name);
		//computerDto.setIntroducedDto(continued);
		//computerDto.setDiscontinuedDto(discontinued);
		//computerDto.setCompanyDto(companyDto);
		
		
		//request.setAttribute("info", computerDto);
		//ComputerService computerService = ComputerService.getInstance();

		//computerService.createComputer(computerDto);
		

		request.getRequestDispatcher(VUE).forward(request, response);
	}

}

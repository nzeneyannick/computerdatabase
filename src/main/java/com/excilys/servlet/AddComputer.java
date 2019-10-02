package com.excilys.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.entities.Company;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;

@SuppressWarnings("serial")
@WebServlet("/addComputer")
public class AddComputer extends HttpServlet {

	public static final String VUE = "/views/addComputer.jsp";

	public static final String CHAMP_NAME_COMPUTER = "name";
	public static final String CHAMP_INTRODUCED = "introduced";
	public static final String CHAMP_DISCONTINUED = "discontinued";
	public static final String CHAMP_NAME_COMPANY = "nameCompany";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Récupération de la liste des compagnies pour affichage du menu deroulant
		 */
		CompanyService companyService = CompanyService.getInstance();
		List<Company> listComp = companyService.getListCompany();

	
		Set<Company> listCompany = new HashSet<Company>(listComp);

		request.setAttribute("listCompany", listCompany);

		request.getRequestDispatcher(VUE).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Récupération de la liste des compagnies pour affichage du menu deroulant
		 */
		CompanyService companyService = CompanyService.getInstance();
		List<Company> listComp = companyService.getListCompany();

		Set<Company> listCompany = new HashSet<Company>(listComp);

		request.setAttribute("listCompany", listCompany);		
		
		/*
		 * Recuperation des données saisi par l'utilisateur
		 */

		String nameComputer = "";
		String introduced = "";
		String discontinued = "";
		String nameCompany = "";

		nameComputer = request.getParameter(CHAMP_NAME_COMPUTER);
		introduced = request.getParameter(CHAMP_INTRODUCED);
		discontinued = request.getParameter(CHAMP_DISCONTINUED);
		nameCompany = request.getParameter(CHAMP_NAME_COMPANY);

		String message;
		boolean erreur;

		if (nameComputer.trim().isEmpty() || introduced.trim().isEmpty() || discontinued.trim().isEmpty()
				|| nameCompany.trim().isEmpty()) {
			// message = "Vous n'avez pas rempli tous les champs obligatoires. <br> <a
			// href=\"views \"addComputer.jsp \">Cliquer ici</a> pour acceder au formulaire,
			// de
			// creation d'un computer";
			message = "Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"views \"addComputer.jsp \">Cliquer ici</a> pour acceder au formulaire, de creation d'un computer";

			erreur = true;

		} else {

			message = "Computer créé avec succès";
			erreur = false;
		}

		/*
		 * peuplement des beans via les données saisies par l'utilisateur
		 */
		
		//CompanyService companyService = CompanyService.getInstance();
		Company company = companyService.findCompanyByName(nameCompany);
		
		CompanyDto companyDto = new CompanyDto();
		companyDto.setIdDto(company.getId());
		companyDto.setNameDto(company.getName());
		
	
		ComputerDto computerDto = new ComputerDto();	

		computerDto.setNameDto(nameComputer);
		computerDto.setIntroducedDto(introduced);
		computerDto.setDiscontinuedDto(discontinued);
		computerDto.setCompanyDto(companyDto);

		/*
		 * Insertion en base de donnée
		 */
		ComputerService computerService = ComputerService.getInstance();
		computerService.createComputer(computerDto);

		request.setAttribute("message", message);

		request.setAttribute("erreur", erreur);

		request.setAttribute("computerDto", computerDto);
		request.getRequestDispatcher(VUE).forward(request, response);

	}

}

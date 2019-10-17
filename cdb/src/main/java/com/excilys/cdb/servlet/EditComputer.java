package com.excilys.cdb.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.excilys.cdb.dto.CompanyDto;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.service.impl.CompanyService;
import com.excilys.cdb.service.impl.ComputerService;
import com.excilys.cdb.validateur.ValidateurFront;

@Component
@SuppressWarnings("serial")
@WebServlet("/editComputer")
public class EditComputer extends HttpServlet {
	@Autowired
	CompanyService companyService;
	@Autowired
	ComputerService computerService;
	private ValidateurFront validateur = new ValidateurFront();
	public static final String VUE = "/views/editComputer.jsp";
	public static final String CHAMP_NAME_COMPUTER = "name";
	public static final String CHAMP_INTRODUCED = "introduced";
	public static final String CHAMP_DISCONTINUED = "discontinued";
	public static final String CHAMP_NAME_COMPANY = "nameCompany";
	public static final String CHAMP_ID_COMPUTER = "id";
	public static String id = "";

	private String resultat;
	 @Override
	  public void init(
	      ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	  }

	private Map<String, String> erreurs = new HashMap<String, String>();

	public void setErreurs(String key, String value) {
		erreurs.put(key, value);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		id = request.getParameter(CHAMP_ID_COMPUTER);

		List<Company> listComp = companyService.getListCompany();

		Set<Company> listCompany = new HashSet<Company>(listComp);

		request.setAttribute("listCompany", listCompany);

		request.getRequestDispatcher(VUE).forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean erreur;

		List<Company> listComp = companyService.getListCompany();
		request.setAttribute("listCompany", listComp);

		String nameComputer = "";
		String introduced = "";
		String discontinued = "";
		String nameCompany = "";

		nameComputer = request.getParameter(CHAMP_NAME_COMPUTER);
		introduced = request.getParameter(CHAMP_INTRODUCED);
		discontinued = request.getParameter(CHAMP_DISCONTINUED);
		nameCompany = request.getParameter(CHAMP_NAME_COMPANY);

		int idCompt = Integer.parseInt(id);

		try {
			validateur.checkDateOrName(nameComputer);
		} catch (Exception e) {
			e.printStackTrace();
			setErreurs(CHAMP_NAME_COMPUTER, e.getMessage());

		}
		try {
			validateur.checkDateOrName(introduced);
		} catch (Exception e) {
			e.printStackTrace();
			setErreurs(CHAMP_INTRODUCED, e.getMessage());
		}
		try {
			validateur.checkDateOrName(discontinued);
		} catch (Exception e) {
			e.printStackTrace();
			setErreurs(CHAMP_DISCONTINUED, e.getMessage());
		}

		if (erreurs.isEmpty()) {
			try {
				validateur.isValidRange(introduced, discontinued);
			} catch (Exception e) {
				e.printStackTrace();
			}

			CompanyDto companyDto = new CompanyDto();
			Company company = new Company();
			company = companyService.findCompanyByName(nameCompany);
			companyDto.setIdDto(company.getId());
			ComputerDto computerDto = new ComputerDto();
			computerDto.setIdDto(idCompt);
			computerDto.setNameDto(nameComputer);
			computerDto.setIntroducedDto(introduced);
			computerDto.setDiscontinuedDto(discontinued);
			computerDto.setCompanyDto(companyDto);

			computerService.updateComputer(computerDto);
			resultat = "Computer modifié avec succès";
			erreur = false;

			request.setAttribute("computerDto", computerDto);
		} else {
			resultat = "echec de la création du Computer";
			erreur = true;
		}

		request.setAttribute("erreur", erreur);
		request.setAttribute("message", resultat);
		request.getRequestDispatcher(VUE).forward(request, response);

	}

}

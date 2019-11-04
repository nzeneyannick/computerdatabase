package com.excilys.cdb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.excilys.cdb.entities.Company;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.service.impl.CompanyService;
import com.excilys.cdb.service.impl.ComputerService;
import com.excilys.cdb.validateur.*;
import com.excilys.cdb.dto.*;

import ch.qos.logback.classic.Logger;
@Controller
@RequestMapping("/")
public class dashboardController {

	String IdCompUpdate;
	@Autowired
	private ComputerService computerService;
	@Autowired
	private CompanyService companyService;
	private ValidateurFront validateur = new ValidateurFront();
	private String resultat;

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(dashboardController.class);

	@GetMapping(value = "/dashboard")
	public String dashboard(ModelMap model) {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerService.getListComputer();
		int sumComputer = listComputer.size();
		model.addAttribute("listComputer", listComputer);
		model.addAttribute("sumComputer", sumComputer);
		return "dashboard";

	}
/*
	@PostMapping(value = "/dashboard")
	public String findComputerByName(@ModelAttribute("search") String search,
			@ModelAttribute("selection") String[] selection, ModelMap model) {
		List<Computer> listComputer = computerService.findByName(search);
		int sumComputer = listComputer.size();
		model.addAttribute("listComputer", listComputer);
		model.addAttribute("sumComputer", sumComputer);

		if (selection.length != 0) {
			String[] tabId = selection[0].split(",");
			if (tabId.length != 0) {
				for (int i = 0; i < tabId.length; i++) {
					int idCompt = Integer.valueOf(tabId[i]);
					computerService.deleteComputer(idCompt);
				}
			}
		}
		return "dashboard";
	}

	@GetMapping(value = "/addComputer")
	public String addComputer(ModelMap model) {
		List<Company> listComp = companyService.getListCompany();
		model.addAttribute("listCompany", listComp);
		return "addComputer";
	}

	@PostMapping(value = "/addComputer")
	public String addComputerValues(@ModelAttribute("name") String name,
			@ModelAttribute("introduced") String introduced, @ModelAttribute("discontinued") String discontinued,
			@ModelAttribute("nameCompany") String nameCompany, ModelMap model) {

		Map<String, String> erreurs = new HashMap<String, String>();
		boolean erreur;
		try {
			validateur.checkDateOrName(name);
		} catch (Exception e) {
			LOG.error("Error checkNameComputer", e);
			erreurs.put(name, e.getMessage());
		}
		try {
			validateur.checkDateOrName(introduced);
		} catch (Exception e) {
			LOG.error("Error checkDateIntroduced", e);
			erreurs.put(introduced, e.getMessage());
		}
		try {
			validateur.checkDateOrName(discontinued);
		} catch (Exception e) {
			LOG.error("Error checkDateDiscontinued", e);
			erreurs.put(discontinued, e.getMessage());
		}
		try {
			validateur.checkDateOrName(nameCompany);
		} catch (Exception ex) {
			LOG.error("Error checkNameCompany", ex);
			erreurs.put(nameCompany, ex.getMessage());
		}

		if (erreurs.isEmpty()) {
			try {
				validateur.isValidRange(introduced, discontinued);
			} catch (Exception ex) {
				LOG.error("Error isValidRangeDate", ex);
			}
			Company company = companyService.findCompanyByName(nameCompany);
			CompanyDto companyDto = new CompanyDto();
			companyDto.setIdDto(company.getId());
			companyDto.setNameDto(company.getName());
			ComputerDto computerDto = new ComputerDto();
			computerDto.setNameDto(name);
			computerDto.setIntroducedDto(introduced);
			computerDto.setDiscontinuedDto(discontinued);
			computerDto.setCompanyDto(companyDto);
			computerService.createComputer(computerDto);
			resultat = "Computer créé avec succès";
			erreur = false;

			model.addAttribute("computerDto", computerDto);
		} else {
			resultat = "echec de la création du Computer";
			erreur = true;
		}

		model.addAttribute("erreur", erreur);
		model.addAttribute("message", resultat);

		return "addComputer";
	}

	@GetMapping(value = "/editComputer")
	public String editComputer(@RequestParam("id") String id, ModelMap model) {
		List<Company> listComp = companyService.getListCompany();
		IdCompUpdate = id;
		model.addAttribute("listCompany", listComp);
		return "editComputer";
	}

	@PostMapping(value = "/editComputer")
	public String updateComputerValues(@ModelAttribute("name") String name,
			@ModelAttribute("introduced") String introduced, @ModelAttribute("discontinued") String discontinued,
			@ModelAttribute("nameCompany") String nameCompany, ModelMap model) {

		CompanyDto companyDto = new CompanyDto();
		ComputerDto computerDto = new ComputerDto();
		Company company = new Company();

		Map<String, String> erreurs = new HashMap<String, String>();
		boolean erreur;
		try {
			int idCompt = Integer.parseInt(IdCompUpdate);
			computerDto.setIdDto(idCompt);
		} catch (NumberFormatException e) {
			erreurs.put("idUpdate", e.getMessage());
		}

		try {
			validateur.checkDateOrName(name);
			computerDto.setNameDto(name);
		} catch (Exception e) {
			LOG.error("Error chechDateOrName", e);
			erreurs.put(name, e.getMessage());
		}
		try {
			validateur.checkDateOrName(introduced);
			computerDto.setIntroducedDto(introduced);
		} catch (Exception e) {
			LOG.error("Error chechDateOrName", e);
			erreurs.put(introduced, e.getMessage());
		}
		try {
			validateur.checkDateOrName(discontinued);
			computerDto.setDiscontinuedDto(discontinued);
		} catch (Exception e) {
			LOG.error("Error chechDateOrName", e);
			erreurs.put(discontinued, e.getMessage());
		}
		if (erreurs.isEmpty()) {
			try {
				validateur.isValidRange(introduced, discontinued);
			} catch (Exception e) {
				LOG.error("Error isValidRange", e);
			}

			company = companyService.findCompanyByName(nameCompany);
			companyDto.setIdDto(company.getId());
			computerDto.setCompanyDto(companyDto);

			computerService.updateComputer(computerDto);
			resultat = "Computer modifié avec succès";
			erreur = false;
		} else {
			resultat = "echec de la création du Computer";
			erreur = true;
		}
		model.addAttribute("erreur", erreur);
		model.addAttribute("message", resultat);
		
		return "editComputer";
	}
	*/
}

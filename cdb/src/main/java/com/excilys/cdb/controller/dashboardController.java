package com.excilys.cdb.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.service.impl.ComputerService;

@Controller
@RequestMapping("/")
public class dashboardController {

	@Autowired
	private ComputerService computerService;
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		List<Computer> listComputer = new ArrayList<Computer>();
		listComputer = computerService.getListComputer();
		int sumComputer = listComputer.size();
		model.addAttribute("listComputer", listComputer);
		model.addAttribute("sumComputer", sumComputer);
		return "dashboard";

	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String findComputerByName(@ModelAttribute ("search") String search, ModelMap model) {
		List<Computer> listComputer = computerService.findByName(search);
		int sumComputer = listComputer.size();
		model.addAttribute("listComputer", listComputer);
		model.addAttribute("sumComputer", sumComputer);		
		return "dashboard";
	}

}

package com.excilys.cdb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.service.IComputerService;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Api(description = "API pour les opérations CRUD sur les computers")
@RestController
@RequestMapping("/computers")
@EnableSwagger2
public class ComputerController {

	@Autowired
	private IComputerService computerService;

	@GetMapping()
	public List<Computer> getAllComputer() {
		List<Computer> computers = computerService.getListComputer();
		return computers;
	}

	@GetMapping("/{id}")
	public Computer getComputerById(@PathVariable("id") int id) {
		Computer computer = computerService.getComputerById(id);
		return computer;
	}

	@DeleteMapping("/{id}")
	public void deleteComputerById(@PathVariable("id") int id) {
		computerService.deleteComputer(id);
	}

	@PostMapping()
	public int addComputer(@RequestBody ComputerDto computerDto) {
		int id = computerService.createComputer(computerDto);
		return id;
	}

	@PutMapping("/{id}")
	public void updateComputer(@PathVariable("id") int id, @RequestBody ComputerDto computerDto) {
		computerService.updateComputer(id, computerDto);
	}

}

package com.excilys.cdb.mapper;
import java.sql.Timestamp;
import org.springframework.stereotype.Component;

import com.excilys.cdb.dto.CompanyDto;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.entities.Computer;

@Component
public class ComputerMapper {

	public Computer convertToComputer(ComputerDto computerDto) {
		Computer computer = new Computer();
		if(computerDto!=null) {
			Company company = new Company();			
			company.setId(computerDto.getCompany().getId());			
			computer.setId(computerDto.getId());
			computer.setName(computerDto.getName());
			computer.setIntroduced(convertStringToTimeStamp(computerDto.getIntroduced()));
			computer.setDiscontinued(convertStringToTimeStamp(computerDto.getDiscontinued()));
			computer.setCompany(company);
		}
		return computer;	
	}
	public ComputerDto convertToComputerDto(Computer computer) {
		ComputerDto computerDto = new ComputerDto();
		CompanyDto companyDto = new CompanyDto();
		computerDto.setId(computer.getId());
		computerDto.setName(computer.getName());
		Timestamp di = computer.getIntroduced();
		Timestamp dd = computer.getDiscontinued();	
		Object oi = di;
		Object od = dd;
		String dateIntro = String.valueOf(oi);
		String dateDisco = String.valueOf(od);
		computerDto.setIntroduced(dateIntro);
		computerDto.setDiscontinued(dateDisco);
		if (null!=computer.getCompany()) {
			companyDto.setId(computer.getCompany().getId());
			companyDto.setName(computer.getCompany().getName());					
		}
		computerDto.setCompany(companyDto);	
		
		return computerDto;
	}	

	public Timestamp convertStringToTimeStamp(String date) {		
		
		Timestamp result = Timestamp.valueOf(date);
		return result;
	}


}

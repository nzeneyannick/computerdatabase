package com.excilys.cdb.mapper;
import java.sql.Timestamp;
import org.springframework.stereotype.Component;
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

	public Timestamp convertStringToTimeStamp(String date) {		
		
		Timestamp result = Timestamp.valueOf(date);
		return result;
	}


}

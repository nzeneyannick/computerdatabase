package com.excilys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;

import com.excilys.entities.Company;
import com.excilys.entities.Computer;

public class ComputerMapper implements RowMapper<Computer>{

	DateTimeFormatter formatter;

	public ComputerMapper() {
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	}

	public Optional<Timestamp> convertStringToTImeSteam(String dateString) {
		if (dateString != null) {
			Timestamp timeStamp;
			LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
			timeStamp = Timestamp.valueOf(localDateTime);
			return Optional.of(timeStamp);
		} else
			return Optional.empty();

	}

	@SuppressWarnings("unchecked")
	public Optional<LocalDate> convertTimeSteamToLocalDate(Timestamp timesteam) {

		return (Optional<LocalDate>) ((timesteam != null) ? Optional.of(timesteam.toLocalDateTime().toLocalDate())
				: Optional.empty());
	}

	@Override
	public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Computer computer = new Computer();
		Company company = new Company();
		computer.setId(rs.getInt("cpt.id"));
		computer.setName(rs.getString("cpt.name"));
		computer.setIntroduced(convertTimeSteamToLocalDate(rs.getTimestamp("cpt.introduced")));
		computer.setDiscontinued(convertTimeSteamToLocalDate(rs.getTimestamp("cpt.discontinued")));
		company.setId(rs.getInt("cpt.company_id"));
		company.setName(rs.getString("cpn.name"));
		computer.setCompagnie(company);		
		return computer;
	}





}

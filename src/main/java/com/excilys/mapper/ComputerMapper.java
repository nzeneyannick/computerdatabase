package com.excilys.mapper;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ComputerMapper {

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





}

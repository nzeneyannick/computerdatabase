package com.excilys.mapper;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComputerMapper {

  DateTimeFormatter formatter;

  public ComputerMapper() {
    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  }

  public Timestamp convertStringToTImeSteam(String dateString) {

    Timestamp timeStamp;
    LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
    timeStamp = Timestamp.valueOf(localDateTime);
    return timeStamp;

  }

  public LocalDate convertTimeSteamToLocalDate(Timestamp timesteam) {

    LocalDate localDate;
    localDate = timesteam.toLocalDateTime().toLocalDate();
    return localDate;

  }

  public LocalDate convertStringToLocalDate(String dateString) {
    LocalDate localDate = LocalDate.parse(dateString);
    return localDate;

  }

  public Timestamp convertLocalDateToTimesteam(LocalDate localDate) {
    String formattedString = localDate.format(formatter);
    Timestamp timeSteam = Timestamp.valueOf(formattedString);
    return timeSteam;

  }

}

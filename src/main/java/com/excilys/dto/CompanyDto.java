package com.excilys.dto;


public class CompanyDto {
  private int idDto;
  private String nameDto;

  public int getIdDto() {
    return idDto;
  }

  public void setIdDto(int idDto) {
    this.idDto = idDto;
  }

  public String getNameDto() {
    return nameDto;
  }

  public void setNameDto(String nameDto) {
    this.nameDto = nameDto;
  }

  
  @Override
public String toString() {
    return "CompanyDto [idDto=" + idDto + ", nameDto=" + nameDto + "]";
  }

 
  @Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + idDto;
    result = prime * result + ((nameDto == null) ? 0 : nameDto.hashCode());
    return result;
  }

 
  @Override
public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CompanyDto other = (CompanyDto) obj;
    if (idDto != other.idDto)
      return false;
    if (nameDto == null) {
      if (other.nameDto != null)
        return false;
    } else if (!nameDto.equals(other.nameDto))
      return false;
    return true;
  }

}

package main.java.com.excilys.dto;

public class ComputerDto {

  private int idDto;
  private String nameDto;
  private String introducedDto;
  private String discontinuedDto;
  private CompanyDto companyDto;

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

  public String getIntroducedDto() {
    return introducedDto;
  }

  public void setIntroducedDto(String introducedDto) {
    this.introducedDto = introducedDto;
  }

  public String getDiscontinuedDto() {
    return discontinuedDto;
  }

  public void setDiscontinuedDto(String discontinuedDto) {
    this.discontinuedDto = discontinuedDto;
  }

  public CompanyDto getCompanyDto() {
    return companyDto;
  }

  public void setCompanyDto(CompanyDto companyDto) {
    this.companyDto = companyDto;
  }

  @Override
  public String toString() {
    return "ComputerDto [id=" + idDto + ", name=" + nameDto + ", introduced=" + introducedDto
        + ", discontinued=" + discontinuedDto + ", id company=" + companyDto.getIdDto() + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((companyDto == null) ? 0 : companyDto.hashCode());
    result = prime * result + ((discontinuedDto == null) ? 0 : discontinuedDto.hashCode());
    result = prime * result + idDto;
    result = prime * result + ((introducedDto == null) ? 0 : introducedDto.hashCode());
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
    ComputerDto other = (ComputerDto) obj;
    if (companyDto == null) {
      if (other.companyDto != null)
        return false;
    } else if (!companyDto.equals(other.companyDto))
      return false;
    if (discontinuedDto == null) {
      if (other.discontinuedDto != null)
        return false;
    } else if (!discontinuedDto.equals(other.discontinuedDto))
      return false;
    if (idDto != other.idDto)
      return false;
    if (introducedDto == null) {
      if (other.introducedDto != null)
        return false;
    } else if (!introducedDto.equals(other.introducedDto))
      return false;
    if (nameDto == null) {
      if (other.nameDto != null)
        return false;
    } else if (!nameDto.equals(other.nameDto))
      return false;
    return true;
  }

}

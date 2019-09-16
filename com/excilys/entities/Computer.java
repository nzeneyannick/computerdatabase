package com.excilys.entities;

import java.time.LocalDate;

// @SuppressWarnings("unused")
public class Computer {

  private int id;
  private String name;
  private LocalDate introduced;
  private LocalDate discontinued;
  private Company compagnie;

  public Computer() {

  }

  public Computer(int id, String name, LocalDate introduced, LocalDate discontinued,
      Company compagnie) {
    super();
    this.id = id;
    this.name = name;
    this.introduced = introduced;
    this.discontinued = discontinued;
    this.compagnie = compagnie;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getIntroduced() {
    return introduced;
  }

  public void setIntroduced(LocalDate introduced) {
    this.introduced = introduced;
  }

  public LocalDate getDiscontinued() {
    return discontinued;
  }

  public void setDiscontinued(LocalDate discontinued) {
    this.discontinued = discontinued;
  }

  public Company getCompagnie() {
    return compagnie;
  }

  public void setCompagnie(Company compagnie) {
    this.compagnie = compagnie;
  }

  @Override
  public String toString() {
    return "Computer [id=" + id + ", name=" + name + ", introduced=" + introduced
        + ", discontinued=" + discontinued + ", compagnieId=" + compagnie.getId() + "]";
  }

}

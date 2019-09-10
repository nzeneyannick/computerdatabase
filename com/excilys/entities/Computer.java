package com.excilys.entities;

import java.sql.Timestamp;
import java.util.*;

//@SuppressWarnings("unused")
public class Computer {

	private int id;
	private String name;
	private Timestamp introduced;
	private Timestamp discontinued;
	private Company compagnie;

	public Computer() {

	}

	public Computer(int id, String name, Timestamp introduced, Timestamp discontinued, Company compagnie) {
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

	public Date getIntroduced() {
		return introduced;
	}

	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}

	public Date getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}

	public Company getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Company compagnie) {
		this.compagnie = compagnie;
	}

}

package com.excilys.application;

import java.awt.Desktop.Action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.dao.impl.ComputerDao;
import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;

public class Application {

	public static void getListCompany() {
		System.out.print("******Affichage de la liste des compagnies ********\r");
		CompanyService companyService = new CompanyService();
		companyService.getListCompany();
	}

	public static void getListComputer() {

		System.out.print("\f\r******Affichage de la liste des computers ********\r");

		ComputerService computerService = new ComputerService();
		computerService.getListComputer();

	}

	public static void createNewComputer(Computer computer) {

		System.out.print("\f\r******Creation d'un new computer ********\r");
		ComputerService computerService = new ComputerService();
		computerService.createComputer(computer);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("====================== Veuillez le numéro de l'action à effectuer ===================== ");
		System.out.println("======  1 : List companies                                                        ===== ");
		System.out.println("======  2 : List computer                                                         ===== ");
		System.out.println("======  3 : Show computer details (the detailed information of only one computer) ===== ");
		System.out.println("======  4 : Create a computer                                                     ===== ");
		System.out.println("======  5 : Update a computer                                                     ===== ");
		System.out.println("======  6 : Delete a computer                                                     ===== ");

		int choixUtilisateur = sc.nextInt();
		System.out.println("Vous avez saisi le nombre : " + choixUtilisateur);

		int action[] = { 1, 2, 3, 4, 5, 6 };
		switch (choixUtilisateur) {
		case 1:
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			;
			getListCompany();

			break;
		case 2:
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			;
			getListComputer();
			break;
		case 3:
			System.out.println();
			break;
		case 4:
			Computer com = new Computer();
			Date date = new Date();
			long time = date.getTime();
			// System.out.println("Time in Milliseconds: " + time);
			// Current timesteam
			Timestamp ts = new Timestamp(time);
			// System.out.println("Current Time Stamp: " + ts);
			System.out.println("Veuillez rentrer les information du computer");
			Scanner infoCpt = new Scanner(System.in);
			System.out.println("Veuillez saisir le name : \r");
			String name = infoCpt.next();
			System.out.println("Valeur courante : introduced => : \r" + ts);
			// String introduced = infoCpt.next();

			System.out.println("Valeur courante : discontinued => : \r" + ts);
			// String discontinued = infoCpt.next();
			System.out.println(" Veuillez saisir le compagnie_id : \r");
			int company_id = infoCpt.nextInt();

			/**
			 * Peuplement du computer avec les variables ci-dessus saisies par l'utilisateur
			 */
			com.setName(name);
			com.setIntroduced(ts);
			com.setDiscontinued(ts);

			// Creation de la compagnie afin de stocker la valeur de clé étrangère
			Company comp = new Company();
			comp.setId(company_id);
			com.setCompagnie(comp);
			ComputerService computerService = new ComputerService();
			computerService.createComputer(com);
			break;
		case 5:
			System.out.println();
			break;
		default:
			System.out.print("Veuillez choisir un nombre compris dans la plage");
		}

	}

}

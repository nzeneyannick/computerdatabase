package com.excilys.application;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;

public class Application {
	static CompanyService companyService = new CompanyService();
	static ComputerService computerService = new ComputerService();
	final static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void getListCompany() {

		System.out.print("******Affichage de la liste des compagnies ********\r");
		companyService.getListCompany();
	}

	public static void getListComputer() {

		System.out.print("\f\r******Affichage de la liste des computers ********\r");
		computerService.getListComputer();

	}

	public static void createNewComputer(Computer computer) {

		System.out.print("\f\r******Creation d'un new computer ********\r");
		computerService.createComputer(computer);

	}

	public static void showComputerDetails(int id) {

		System.out.print("\f\r******Affichage des details d'un computer ********\r");
		computerService.showComputerDetail(id);

	}

	public static void deleteIdComputer(int id) {
		System.out.print("\f\r******Suppression d'un computer ********\r");
		computerService.deleteComputer(id);

	}

	public static void UpdateComputer(Computer computer) {
		System.out.print("\f\r******mise à jour d'un computer ********\r");
		computerService.updateComputer(computer);

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
				logger.error("Exception ::" + e);

			}
			;
			getListCompany();

			break;
		case 2:
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				logger.error("Exception ::" + e);

			}
			;
			getListComputer();
			break;
		case 3:
			System.out.println("Veuillez rentrer l'id du computer recherché ");
			int idc = sc.nextInt();
			showComputerDetails(idc);

			break;
		case 4:
			Computer com = new Computer();
			// Creation de la compagnie afin de stocker la valeur de clé étrangère
			Company company = new Company();

			System.out.println("Veuillez rentrer les information du computer");

			System.out.println("Veuillez saisir le name : \r");
			Scanner scanName = new Scanner(System.in);
			String name = scanName.next();

			System.out.println("Veuillez rentrer la date introduced ");
			Scanner scanDataIntroduced = new Scanner(System.in);
			String dateIntroduced = scanDataIntroduced.nextLine();
			DateTimeFormatter formatterIntroduced = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime localDateTimeIntro = LocalDateTime.parse(dateIntroduced, formatterIntroduced);
			Timestamp introduced = Timestamp.valueOf(localDateTimeIntro);

			System.out.println("Veuillez rentrer la date discontinued");
			Scanner scanDataDiscontinued = new Scanner(System.in);
			String dateDiscontinued = scanDataDiscontinued.nextLine();
			DateTimeFormatter formatterDiscontinued = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime localDateTimeDiscon = LocalDateTime.parse(dateDiscontinued, formatterDiscontinued);
			Timestamp discontinued = Timestamp.valueOf(localDateTimeDiscon);

			System.out.println(" Veuillez saisir le compagnie_id : \r");
			Scanner scanId = new Scanner(System.in);
			int company_id = scanId.nextInt();

			company.setId(company_id);

			/**
			 * Peuplement du computer avec les variables ci-dessus saisies par l'utilisateur
			 */
			com.setName(name);
			com.setIntroduced(introduced);
			com.setDiscontinued(discontinued);
			com.setCompagnie(company);

			createNewComputer(com);

			break;
		case 5:
			Computer computer = new Computer();
			// Creation de la compagnie afin de stocker la valeur de clé étrangère
			Company companyUpdate = new Company();
			int idComputerUpdate;
			String nameComputerUpdate;
			Timestamp introducedComputerUpdate;
			Timestamp discontinuedComputerUpdate;
			int companyIdComputerUpdate;

			System.out.println("Veuillez rentrer l'id du computer à modifier ");
			Scanner idUpdate = new Scanner(System.in);
			idComputerUpdate = idUpdate.nextInt();

			System.out.println("Veuillez rentrer le nouveau name ");
			Scanner nameUpdate = new Scanner(System.in);
			nameComputerUpdate = nameUpdate.next();

			System.out.println("Veuillez rentrer la nouvelle date introduced ");
			Scanner scanIntroducedUpdate = new Scanner(System.in);
			/*
			 * recuperation de la date introduced et discontinued en String à l'entrée et
			 * conversion en Timestream à la sortie en passant par LocalDateTime
			 */
			String newdateIntroducedUpdate = scanIntroducedUpdate.nextLine();
			System.out.println(newdateIntroducedUpdate);
			DateTimeFormatter newformatterIntroducedUpdate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

			LocalDateTime dateTimeIntroduced = LocalDateTime.parse(newdateIntroducedUpdate,
					newformatterIntroducedUpdate);
			introducedComputerUpdate = Timestamp.valueOf(dateTimeIntroduced);

			System.out.println("Veuillez rentrer la nouvelle date discontinued ");
			Scanner newdataDiscontinued = new Scanner(System.in);
			/*
			 * recuperation de la date introduced et discontinued en String à l'entrée et
			 * conversion en Timestream à la sortie en passant par LocalDateTime
			 */
			String newdateDiscontinuedUpdate = newdataDiscontinued.nextLine();
			// String dateDiscontinued = "2017-03-08 12:30:54";
			DateTimeFormatter formatterDiscontUpdate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTimeDiscontUpdate = LocalDateTime.parse(newdateDiscontinuedUpdate,
					formatterDiscontUpdate);
			discontinuedComputerUpdate = Timestamp.valueOf(dateTimeDiscontUpdate);

			System.out.println("Veuillez choisir la valeur de la company_id");
			Scanner newdataCompany_idUpdate = new Scanner(System.in);

			companyIdComputerUpdate = newdataCompany_idUpdate.nextInt();
			companyUpdate.setId(companyIdComputerUpdate);

			/**
			 * Peuplement du computer avec les variables ci-dessus saisies par l'utilisateur
			 */
			computer.setId(idComputerUpdate);
			computer.setName(nameComputerUpdate);
			computer.setIntroduced(introducedComputerUpdate);
			computer.setDiscontinued(discontinuedComputerUpdate);
			computer.setCompagnie(companyUpdate);

			UpdateComputer(computer);

			break;
		case 6:
			System.out.println("Veuillez l'identifiant du computer à supprimer");
			Scanner s = new Scanner(System.in);
			int idCompt = s.nextInt();
			deleteIdComputer(idCompt);
			break;
		default:
			System.out.print("Veuillez choisir un nombre compris dans la plage");
		}

	}

}

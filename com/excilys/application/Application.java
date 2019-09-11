package com.excilys.application;

import java.awt.Desktop.Action;
import java.util.*;
import java.util.Map.Entry;

import com.excilys.dao.impl.CompanyDao;
import com.excilys.dao.impl.ComputerDao;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;

public class Application {

	public static void getListCompany() {
		System.out.print("******Affichage de la liste des compagnies ********\r");
		CompanyDao companyDao = new CompanyDao();
		CompanyService companyService = new CompanyService();
		companyService.getListCompany(companyDao.getListCompany());
	}

	public static void getListComputer() {

		System.out.print("\f\r******Affichage de la liste des computers ********\r");
		ComputerDao computerDao = new ComputerDao();
		ComputerService computerService = new ComputerService();
		computerService.getListComputer(computerDao.getListComputer());

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("======Veuillez le numéro de l'action à effectuer=====");
		System.out.println("=  1 : List companies     =");
		System.out.println("=  2 : List computer      =");
		System.out.println("=  3 : Show computer details (the detailed information of only one computer)   =");
		System.out.println("=  4 : Create a computer  =");
		System.out.println("=  5 : Update a computer  =");
		System.out.println("=  6 : Delete a computer  =");

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
			System.out.println();
			break;
		case 5:
			System.out.println();
			break;
		default:
			System.out.print("Veuillez choisir un nombre compris dans la plage");
		}

	}

}

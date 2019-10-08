
package com.excilys.application;

import java.util.List;
import java.util.Scanner;

import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.service.impl.CompanyService;
import com.excilys.service.impl.ComputerService;
import com.excilys.validateur.ValidateurBack;

public class Application {
	private static CompanyService companyService = CompanyService.getInstance();
	private static ComputerService computerService = ComputerService.getInstance();
	private static ValidateurBack validateur = new ValidateurBack();

	public static void getListCompany() {

		System.out.print("******Affichage de la liste des compagnies ********\r");
		List<Company> listCompany = companyService.getListCompany();
		for (Company company : listCompany) {
			System.out.println(company.toString());
		}

	}

	public static void getListComputer() {

		System.out.print("\f\r******Affichage de la liste des computers ********\r");
		List<Computer> listComputer;
		listComputer = computerService.getListComputer();
		for (Computer computer : listComputer) {
			System.out.println(computer.toString());
		}

	}

	public static void createNewComputer(ComputerDto computerDto) {

		System.out.print("\f\r******Creation d'un new computer ********\r");
		computerService.createComputer(computerDto);

	}

	public static void showComputerDetails(int id) {

		System.out.print("\f\r******Affichage des details d'un computer ********\r");
		System.out.print(computerService.showComputerDetail(id).toString());

	}

	public static void deleteIdComputer(int id) {
		System.out.print("\f\r******Suppression d'un computer ********\r");
		computerService.deleteComputer(id);

	}

	public static void UpdateComputer(ComputerDto computerDto) {
		System.out.print("\f\r******mise à jour d'un computer ********\r");
		computerService.updateComputer(computerDto);

	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("====================== Veuillez le numéro de l'action à effectuer =====================");
		System.out
				.println("=                                                                                       = ");
		System.out
				.println("=         1 : List companies                                                            = ");
		System.out
				.println("=         2 : List computer                                                             = ");
		System.out
				.println("=         3 : Show computer details (the detailed information of only one computer      = ");
		System.out
				.println("=         4 : Create a computer                                                         = ");
		System.out
				.println("=         5 : Update a computer                                                         = ");
		System.out
				.println("=         6 : Delete a computer                                                         = ");

		System.out.println("======================================================================================= ");

		int choixUtilisateur = sc.nextInt();

		switch (choixUtilisateur) {
		case 1:
			getListCompany();
			break;

		case 2:
			getListComputer();
			break;

		case 3:
			int idc = 0;
			System.out.println("Veuillez rentrer l'id du computer recherché ");
			idc = sc.nextInt();
			showComputerDetails(idc);
			break;

		case 4:
			CompanyDto companyDto = new CompanyDto();
			ComputerDto computerDto = new ComputerDto();

			System.out.println("Veuillez rentrer les information du computer");
			System.out.println("Veuillez saisir le name : \r");
			String name = sc.next();

			try {
				validateur.checkDateOrName(name);
			} catch (Exception e) {
			
				e.printStackTrace();
			}

			computerDto.setNameDto(name);

			System.out.println("Veuillez rentrer la date introduced ");
			sc.nextLine();
			String dateIntroducedDto = sc.nextLine();
			try {
				validateur.checkDateOrName(dateIntroducedDto);
			} catch (Exception e) {
		
				e.printStackTrace();
			}

			computerDto.setIntroducedDto(dateIntroducedDto);

			System.out.println("Veuillez rentrer la date discontinued");
			String dateDiscontinuedDto = sc.nextLine();

			computerDto.setDiscontinuedDto(dateDiscontinuedDto);
			try {
				validateur.checkDateOrName(dateDiscontinuedDto);
			} catch (Exception e) {
			
				e.printStackTrace();
			}

			try {
				validateur.isValidRange(dateIntroducedDto, dateDiscontinuedDto);
			} catch (Exception e) {
			
				e.printStackTrace();
			}

			System.out.println(" Veuillez saisir le compagnie_id : \r");
			int company_idDto = sc.nextInt();
			companyDto.setIdDto(company_idDto);
			computerDto.setCompanyDto(companyDto);

			createNewComputer(computerDto);

			System.out.println("Computer créé avec sucess \n" + computerDto.toString());

			break;
		case 5:
			CompanyDto companyDtoUpdate = new CompanyDto();
			ComputerDto computerDto2 = new ComputerDto();

			System.out.println("Veuillez rentrer l'id du computer à modifier ");
			int idCompt = sc.nextInt();
			try {
				validateur.checkId(idCompt);
			}catch(Exception e) {
				e.printStackTrace();
			}
			computerDto2.setIdDto(idCompt);
			
			sc.nextLine();
			System.out.println("Veuillez rentrer le nouveau name ");
			String nameCompt = sc.nextLine();
			try {
				validateur.checkDateOrName(nameCompt);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			computerDto2.setNameDto(nameCompt);

			System.out.println("Veuillez rentrer la nouvelle date introduced ");
			String dateIntroCompt = sc.nextLine();

			try {
				validateur.checkDateOrName(dateIntroCompt);
			} catch (Exception e) {
				e.printStackTrace();
			}

			computerDto2.setIntroducedDto(dateIntroCompt);
			System.out.println("Veuillez rentrer la nouvelle date discontinued ");
			String dateDiscon = sc.nextLine();
			//Scanner newdataDiscontinued = new Scanner(System.in);

			try {
				validateur.checkDateOrName(dateDiscon);
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			//newdataDiscontinued.nextLine();
			computerDto2.setDiscontinuedDto(dateDiscon);
			
			System.out.println("Veuillez choisir la valeur de la company_id");
			
			companyDtoUpdate.setIdDto(Integer.parseInt(sc.nextLine()));
			computerDto2.setCompanyDto(companyDtoUpdate);

			UpdateComputer(computerDto2);
			System.out.println("Mise à jour effectué avec succes\n" + computerDto2.toString());
			break;

		case 6:
			System.out.println("Veuillez l'identifiant du computer à supprimer");
			int idCompter = sc.nextInt();
			try {
				validateur.checkId(idCompter);
				deleteIdComputer(idCompter);
				System.out.println("Suppression effectué avec succes");
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			break;

		default:
			System.out.print("Veuillez choisir un nombre compris dans la plage");
		}
		sc.close();

	}
}

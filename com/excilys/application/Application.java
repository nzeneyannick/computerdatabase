package com.excilys.application;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.excilys.dto.CompanyDto;
import com.excilys.dto.ComputerDto;
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

  public static void createNewComputer(ComputerDto computerDto) {

    System.out.print("\f\r******Creation d'un new computer ********\r");
    computerService.createComputer(computerDto);

  }

  public static void showComputerDetails(int id) {

    System.out.print("\f\r******Affichage des details d'un computer ********\r");
    computerService.showComputerDetail(id);

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
    System.out.println(
        "====================== Veuillez le numéro de l'action à effectuer ===================== ");
    System.out.println(
        "======  1 : List companies                                                        ===== ");
    System.out.println(
        "======  2 : List computer                                                         ===== ");
    System.out.println(
        "======  3 : Show computer details (the detailed information of only one computer) ===== ");
    System.out.println(
        "======  4 : Create a computer                                                     ===== ");
    System.out.println(
        "======  5 : Update a computer                                                     ===== ");
    System.out.println(
        "======  6 : Delete a computer                                                     ===== ");

    int choixUtilisateur = sc.nextInt();
    System.out.println("Vous avez saisi le nombre : " + choixUtilisateur);

    int action[] = {1, 2, 3, 4, 5, 6};

    switch (choixUtilisateur) {
      case 1:
        getListCompany();
        break;

      case 2:
        getListComputer();
        break;

      case 3:
        System.out.println("Veuillez rentrer l'id du computer recherché ");
        int idc = sc.nextInt();
        showComputerDetails(idc);
        break;

      case 4:
        Computer com = new Computer();
        CompanyDto companyDto = new CompanyDto();
        ComputerDto computerDto = new ComputerDto();

        System.out.println("Veuillez rentrer les information du computer");
        System.out.println("Veuillez saisir le name : \r");
        Scanner scanName = new Scanner(System.in);
        String name = scanName.next();
        computerDto.setNameDto(name);

        System.out.println("Veuillez rentrer la date introduced ");
        Scanner scanDataIntroduced = new Scanner(System.in);
        String dateIntroducedDto = scanDataIntroduced.nextLine();
        computerDto.setIntroducedDto(dateIntroducedDto);

        System.out.println("Veuillez rentrer la date discontinued");
        Scanner scanDataDiscontinued = new Scanner(System.in);
        String dateDiscontinuedDto = scanDataDiscontinued.nextLine();
        computerDto.setDiscontinuedDto(dateDiscontinuedDto);

        System.out.println(" Veuillez saisir le compagnie_id : \r");
        Scanner scanId = new Scanner(System.in);
        int company_idDto = scanId.nextInt();
        companyDto.setIdDto(company_idDto);
        computerDto.setCompanyDto(companyDto);

        createNewComputer(computerDto);
        System.out.println("Computer créé avec sucess \n" + computerDto.toString());

        break;
      case 5:
        CompanyDto companyDtoUpdate = new CompanyDto();
        ComputerDto computerDto2 = new ComputerDto();

        System.out.println("Veuillez rentrer l'id du computer à modifier ");
        Scanner idUpdate = new Scanner(System.in);
        computerDto2.setIdDto(idUpdate.nextInt());

        System.out.println("Veuillez rentrer le nouveau name ");
        Scanner nameUpdate = new Scanner(System.in);
        computerDto2.setNameDto(nameUpdate.next());

        System.out.println("Veuillez rentrer la nouvelle date introduced ");
        Scanner scanIntroducedUpdate = new Scanner(System.in);
        /*
         * recuperation de la date introduced et discontinued en String à l'entrée et conversion en
         * Timestream à la sortie en passant par LocalDateTime
         */
        computerDto2.setIntroducedDto(scanIntroducedUpdate.nextLine());
        System.out.println("Veuillez rentrer la nouvelle date discontinued ");
        Scanner newdataDiscontinued = new Scanner(System.in);
        /*
         * recuperation de la date introduced et discontinued en String à l'entrée et conversion en
         * Timestream à la sortie en passant par LocalDateTime
         */
        computerDto2.setDiscontinuedDto(newdataDiscontinued.nextLine());
        System.out.println("Veuillez choisir la valeur de la company_id");
        Scanner newdataCompany_idUpdate = new Scanner(System.in);
        // companyIdComputerUpdate = newdataCompany_idUpdate.nextInt();
        companyDtoUpdate.setIdDto(newdataCompany_idUpdate.nextInt());
        computerDto2.setCompanyDto(companyDtoUpdate);

        UpdateComputer(computerDto2);
        System.out.println("Mise à jour effectué avec succes\n" + computerDto2.toString());
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

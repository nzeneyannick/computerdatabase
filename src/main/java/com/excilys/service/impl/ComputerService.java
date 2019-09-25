package main.java.com.excilys.service.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.excilys.dao.impl.ComputerDao;
import main.java.com.excilys.dto.ComputerDto;
import main.java.com.excilys.entities.Computer;
import main.java.com.excilys.service.IComputerService;


public class ComputerService implements IComputerService {

  ComputerDao computerDao;

  private ComputerService() {
    computerDao = ComputerDao.getInstance();
  }

  /** Instance unique pré-initialisée */
  private static ComputerService INSTANCE = new ComputerService();

  public static ComputerService getInstance() {
    return INSTANCE;
  }

  /**
   * Implemenetation de la fonction affichage de la liste des computers
   */
  public List<Computer> getListComputer() {
    List<Computer> listComputer = new ArrayList<Computer>();
    listComputer = computerDao.getListComputer();
    return listComputer;
  }

  /**
   * Implementation de la fonction creation d'un computer
   */
  public void createComputer(ComputerDto computerDto) {
    computerDao.createComputer(computerDto);
  }

  /**
   * Implementation de la fonction delete computer
   */
  public void deleteComputer(int id) {
    computerDao.deleteComputer(id);
    System.out.println("Computer numéro :" + id + " supprimé \n");

  }

  /**
   * Implementation de la fonction show details computer
   */
  public Computer showComputerDetail(int idComputer) {
    Computer computer = new Computer();
    computer = computerDao.showComputerDetail(idComputer);
   
return computer;
  }

  public void updateComputer(ComputerDto computerDto) {
    computerDao.updateComputer(computerDto);
  }

}

package com.excilys.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.excilys.dao.impl.ComputerDao;
import com.excilys.dto.ComputerDto;
import com.excilys.entities.Computer;
import com.excilys.service.IComputerService;

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
  @Override
  public List getListComputer() {
    List<Computer> listComputer = new ArrayList<Computer>();
    listComputer = computerDao.getListComputer();
    return listComputer;
  }

  /**
   * Implementation de la fonction creation d'un computer
   */
  @Override
  public void createComputer(ComputerDto computerDto) {
    computerDao.createComputer(computerDto);
  }

  /**
   * Implementation de la fonction delete computer
   */
  @Override
  public void deleteComputer(int id) {
    computerDao.deleteComputer(id);
    System.out.println("Computer numéro :" + id + " supprimé \n");

  }

  /**
   * Implementation de la fonction show details computer
   */
  @Override
  public void showComputerDetail(int idComputer) {
    Computer computer = new Computer();
    computer = computerDao.showComputerDetail(idComputer);
    System.out.println(computer.toString());

  }

  @Override
  public void updateComputer(ComputerDto computerDto) {
    computerDao.updateComputer(computerDto);
  }

}

package main.java.com.excilys.dao;

import java.util.List;

import main.java.com.excilys.dto.ComputerDto;
import main.java.com.excilys.entities.Computer;


public interface IComputerDao {
  /**
   * Fonction retournaNt la liste des computers en base
   */
  public List<Computer> getListComputer();

  /**
   * Fonction permettant de creer un computer
   */
  public void createComputer(ComputerDto computerDto);

  /**
   * Fonction permettant d'afficher les details d'un computer
   */
  public Computer showComputerDetail(int id);

  /**
   * Suppression d'un computer
   */
  public void deleteComputer(int id);

  /**
   * Fonction mise à jour d'un computer
   */
  public void updateComputer(ComputerDto computerDto);

}

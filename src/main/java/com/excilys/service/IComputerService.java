package main.java.com.excilys.service;

import java.util.List;

import main.java.com.excilys.dto.ComputerDto;
import main.java.com.excilys.entities.Computer;


public interface IComputerService {
  /**
   * Affichage de la liste des computers
   */
  public List getListComputer();

  /**
   * Creation d'un computer
   */
  public void createComputer(ComputerDto computerDto);

  /**
   * Afficher les details d'un computer
   */
  public Computer showComputerDetail(int idComputer);

  /**
   * Suppression d'un computer
   */
  public void deleteComputer(int id);

  /**
   * Mise à jour d'un computer
   */
  public void updateComputer(ComputerDto computerDto);

}

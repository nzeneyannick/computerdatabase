package com.excilys.service.impl;

import java.util.ArrayList;
import java.util.List;



import com.excilys.dao.impl.ComputerDao;
import com.excilys.dto.ComputerDto;
import com.excilys.entities.Computer;
import com.excilys.service.IComputerService;


public class ComputerService implements IComputerService {

  ComputerDao computerDao;
	//final static Logger logger = LoggerFactory.getLogger(ComputerService.class);

  private ComputerService() {
    computerDao = ComputerDao.getInstance();
  }

  /** Instance unique pré-initialisée */
  private static ComputerService INSTANCE;

  public static ComputerService getInstance() {
	  if (INSTANCE == null)
      {   INSTANCE = new ComputerService(); 
      }
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

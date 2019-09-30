package com.excilys.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;

import com.excilys.dao.IComputerDao;
import com.excilys.dto.ComputerDto;
import com.excilys.entities.Company;
import com.excilys.entities.Computer;
import com.excilys.mapper.ComputerMapper;

public class ComputerDao implements IComputerDao {

	private static final String LISTOFCOMPUTER = "select " + "cpt.id" + ", cpt.name" + ", cpt.introduced"
			+ ",cpt.discontinued" + ",cpt.company_id " + ", cpn.name" + " from " + "company cpn "
			+ "inner join computer cpt " + "     on cpn.id=cpt.company_id " + " order by cpt.id ;\n ";
	private static final String NEWCOMPUTER = "INSERT INTO computer(name,introduced, discontinued,company_id ) VALUES (?,?,?,?);";
	private static final String FINDCOMPUTERBYID = "select id, name, introduced, discontinued,company_id from computer where id=?;";
	private static final String DELETEIDCOMPUTER = "delete from computer where id = ?";
	private static final String UPDATECOMPUTERBYID = "update computer set name=?, introduced=?,discontinued=?,company_id=? where id=? ;";
	// final static Logger logger = LoggerFactory.getLogger(ComputerDao.class);

	private ComputerDao() {

	}

	/** Instance unique pré-initialisée */
	private static ComputerDao INSTANCE = new ComputerDao();

	/** Point d'accès pour l'instance unique du singleton */
	public static ComputerDao getInstance() {
		return INSTANCE;
	}

	public List<Computer> getListComputer() {
		List<Computer> list = new ArrayList<Computer>();
		ComputerMapper computerMapper = new ComputerMapper();
		try {
			ConnexionBd connexion = ConnexionBd.getInstance();
			Statement statement = connexion.getConnexionBd().createStatement();
			ResultSet resultset = statement.executeQuery(LISTOFCOMPUTER);

			while (resultset.next()) {
				int id = resultset.getInt("cpt.id");
				String nameComputer = resultset.getString("cpt.name");
				Timestamp introduced = resultset.getTimestamp("cpt.introduced");
				Timestamp discontinued = resultset.getTimestamp("cpt.discontinued");
				int companyId = resultset.getInt("cpt.company_id");
				String nameCompany = resultset.getString("cpn.name");

				Computer computer = new Computer();
				Company company = new Company();
				computer.setId(id);
				computer.setName(nameComputer);
				computer.setIntroduced(computerMapper.convertTimeSteamToLocalDate(introduced));
				computer.setDiscontinued(computerMapper.convertTimeSteamToLocalDate(discontinued));

				company.setId(companyId);
				company.setName(nameCompany);

				computer.setCompagnie(company);

				list.add(computer);
			}
		} catch (SQLException e) {

			// LOGGER.error("SQEXCEPTION ::" + e);
		}

		return list;
	}

	public void createComputer(ComputerDto computerDto) {
		ComputerMapper computerMapper = new ComputerMapper();

		try {
			ConnexionBd connexion = ConnexionBd.getInstance();
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(NEWCOMPUTER);
			preparedStatement.setString(1, computerDto.getNameDto());

			computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto());
			preparedStatement.setTimestamp(2, computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()));

			preparedStatement.setTimestamp(3,
					computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()));

			preparedStatement.setInt(4, computerDto.getCompanyDto().getIdDto());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// logger.error("SQEXCEPTION ::" + e);
		}
	}

	public Computer showComputerDetail(int idComputer) {
		Computer computerDetail = new Computer();
		Company company = new Company();
		ComputerMapper computerMapper = new ComputerMapper();

		try {
			ConnexionBd connexion = ConnexionBd.getInstance();
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(FINDCOMPUTERBYID);
			// Trie effectué sur l'id du computer
			preparedStatement.setInt(1, idComputer);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				LocalDate introduced = computerMapper.convertTimeSteamToLocalDate(resultset.getTimestamp("introduced"));
				LocalDate discontinued = computerMapper
						.convertTimeSteamToLocalDate(resultset.getTimestamp("discontinued"));
				int companyId = resultset.getInt("company_id");
				computerDetail.setId(id);
				computerDetail.setName(name);

				computerDetail.setIntroduced(introduced);
				computerDetail.setDiscontinued(discontinued);
				company.setId(companyId);
				computerDetail.setCompagnie(company);
			}
		} catch (SQLException e) {
			// LOGGER.error("SQEXCEPTION ::" + e);
		}
		return computerDetail;
	}

	public void deleteComputer(int id) {
		try {
			ConnexionBd connexion = ConnexionBd.getInstance();
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(DELETEIDCOMPUTER);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Suppression effectué avec succes");
		} catch (SQLException e) {
			// LOGGER.error("SQEXCEPTION ::" + e);
		}

	}

	public void updateComputer(ComputerDto computerDto) {
		ComputerMapper computerMapper = new ComputerMapper();
		try {
			ConnexionBd connexion = ConnexionBd.getInstance();
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(UPDATECOMPUTERBYID);
			preparedStatement.setString(1, computerDto.getNameDto());
			preparedStatement.setTimestamp(2, computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()));
			preparedStatement.setTimestamp(3,
					computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()));
			preparedStatement.setInt(4, computerDto.getCompanyDto().getIdDto());
			preparedStatement.setInt(5, computerDto.getIdDto());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// LOGGER.error("SQEXCEPTION ::" + e);
		}

	}

}

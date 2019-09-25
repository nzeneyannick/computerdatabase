package main.java.com.excilys.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.excilys.dao.IComputerDao;
import main.java.com.excilys.dto.ComputerDto;
import main.java.com.excilys.entities.Company;
import main.java.com.excilys.entities.Computer;
import main.java.com.excilys.mapper.ComputerMapper;


public class ComputerDao implements IComputerDao {
	private ConnexionBd connexion;
	Statement statement;
	ResultSet resultset;
	private static final String LISTOFCOMPUTER = "select " + "cpt.id" + ", cpt.name" + ", cpt.introduced"
			+ ",cpt.discontinued" + ",cpt.company_id " + " from " + "company cpn " + "inner join computer cpt "
			+ "     on cpn.id=cpt.company_id " + "limit 10;\n ";
	private static final String NEWCOMPUTER = "INSERT INTO computer(name,introduced, discontinued,company_id ) VALUES (?,?,?,?);";
	private static final String FINDCOMPUTERBYID = "select id, name, introduced, discontinued,company_id from computer where id=?;";
	private static final String DELETEIDCOMPUTER = "delete from computer where id = ?";
	private static final String UPDATECOMPUTERBYID = "update computer set name=?, introduced=?,discontinued=?,company_id=? where id=? ;";
	final static Logger logger = LoggerFactory.getLogger(ComputerDao.class);

	private ComputerDao() {
		super();
		this.connexion = ConnexionBd.getInstance();
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
			statement = connexion.getConnexionBd().createStatement();

			resultset = statement.executeQuery(LISTOFCOMPUTER);

			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				Timestamp introduced = resultset.getTimestamp("introduced");
				Timestamp discontinued = resultset.getTimestamp("discontinued");
				int companyId = resultset.getInt("company_id");

				Computer computer = new Computer();
				Company company = new Company();
				computer.setId(id);
				computer.setName(name);
				computer.setIntroduced(computerMapper.convertTimeSteamToLocalDate(introduced));
				computer.setDiscontinued(computerMapper.convertTimeSteamToLocalDate(discontinued));

				company.setId(companyId);

				computer.setCompagnie(company);

				list.add(computer);
			}
		} catch (SQLException e) {

			logger.error("SQEXCEPTION ::" + e);
		}

		finally {
			// Fermeture de la connexion
			try {
				if (resultset != null)
					resultset.close();
				if (statement != null)
					statement.close();
				if (connexion.getConnexionBd() != null)
					connexion.getConnexionBd().close();
			} catch (SQLException ignore) {
				logger.error("SQEXCEPTION ::" + ignore);
			}
		}
		return list;
	}

	public void createComputer(ComputerDto computerDto) {
		ComputerMapper computerMapper = new ComputerMapper();

		try {
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(NEWCOMPUTER);
			preparedStatement.setString(1, computerDto.getNameDto());

			computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto());
			preparedStatement.setTimestamp(2, computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()));

			preparedStatement.setTimestamp(3,
					computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()));

			preparedStatement.setInt(4, computerDto.getCompanyDto().getIdDto());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			logger.error("SQEXCEPTION ::" + e);
		}
	}

	public Computer showComputerDetail(int idComputer) {
		Computer computerDetail = new Computer();
		Company company = new Company();
		ComputerMapper computerMapper = new ComputerMapper();

		try {
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(FINDCOMPUTERBYID);
			// Trie effectué sur l'id du computer
			preparedStatement.setInt(1, idComputer);
			resultset = preparedStatement.executeQuery();
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
			logger.error("SQEXCEPTION ::" + e);
		} finally {

			try {
				if (resultset != null)
					resultset.close();
				if (statement != null)
					statement.close();
				if (connexion.getConnexionBd() != null)
					connexion.getConnexionBd().close();
			} catch (SQLException e) {
				logger.error("SQEXCEPTION ::" + e);
			}
		}
		return computerDetail;
	}

	public void deleteComputer(int id) {
		try {
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(DELETEIDCOMPUTER);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Suppression effectué avec succes");
		} catch (SQLException e) {
			logger.error("SQEXCEPTION ::" + e);
		}

	}

	public void updateComputer(ComputerDto computerDto) {
		ComputerMapper computerMapper = new ComputerMapper();
		try {
			PreparedStatement preparedStatement = connexion.getConnexionBd().prepareStatement(UPDATECOMPUTERBYID);
			preparedStatement.setString(1, computerDto.getNameDto());
			preparedStatement.setTimestamp(2, computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()));
			preparedStatement.setTimestamp(3,
					computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()));
			preparedStatement.setInt(4, computerDto.getCompanyDto().getIdDto());
			preparedStatement.setInt(5, computerDto.getIdDto());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQEXCEPTION ::" + e);
		}

	}

}

package com.excilys.cdb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.excilys.cdb.dao.IComputerDao;
import com.excilys.cdb.dto.ComputerDto;
import com.excilys.cdb.entities.Company;
import com.excilys.cdb.entities.Computer;
import com.excilys.cdb.mapper.ComputerMapper;
import com.excilys.cdb.utils.DBUtil;

@Repository
public class ComputerDao implements IComputerDao {
	private ComputerMapper computerMapper = new ComputerMapper();

	private static final String LISTOFCOMPUTER = ""
			+ "SELECT " 
					+ " cpt.id" 
					+ " ,cpt.name" 
					+ " ,cpt.introduced"
					+ " ,cpt.discontinued"
					+ " ,cpt.company_id "
					+ ", cpn.name"
			+ " FROM " 
					+ "computer cpt "
					+ "left join company cpn "
					+ "     on cpn.id=cpt.company_id "
			+ " ORDER BY"
					+ " cpt.id, cpt.name ;";


	private static final String NEWCOMPUTER = ""
			+ "INSERT INTO "
			+ 	"computer("
			+ 			"name"
			+ 			",introduced "
			+		    ",discontinued"
			+ 			",company_id )"
			+ 			"VALUES (?,?,?,?);";	
	
	private static final String FINDCOMPUTERBYID = ""
			+ "SELECT "
					+ " id"
					+ ", name"
					+ ", introduced"
					+ ", discontinued"
					+ ",company_id "
			+ "FROM "
					+ "computer "
			+ " WHERE"
			+ " id=?;";
	
	private static final String DELETEIDCOMPUTER = ""
			+ "DELETE"
			+ " FROM "
					+ "computer"
			+ " WHERE"
					+ " id = ?;";
	

	private static final String UPDATECOMPUTERBYID = 
			"UPDATE "
					+ "computer"
			+ " set "
					+ "name=?"
					+ ", introduced=?"
					+ ", discontinued=?"
					+ ", company_id=? "
			+ "where"
					+ " id =?;";

	
	private static final String FINDBYNAME = ""
			+ "SELECT " 
					+ "cpt.id" 
					+ " ,cpt.name" 
					+ " ,cpt.introduced"
					+ " ,cpt.discontinued"
					+ " ,cpt.company_id "
					+ " ,cpn.name"
			+ " FROM " 
					+ " computer cpt "
					+ " left join company cpn "
					+ " on cpn.id=cpt.company_id "
			+ " WHERE "
					+ " cpt.name like ?"					
			+ " ORDER BY"
					+ " cpt.name;";	


	public List<Computer> getListComputer() {	
		
		JdbcTemplate vjdbcTemplate = new JdbcTemplate(DBUtil.getDataSource());
		List<Computer> listComputer = vjdbcTemplate.query(LISTOFCOMPUTER, new ComputerMapper() );
		return listComputer;
	}

	public void createComputer(ComputerDto computerDto) {
		ComputerMapper computerMapper = new ComputerMapper();

		try {
			Connection connection = DBUtil.getDataSource().getConnection();				
			PreparedStatement preparedStatement = connection.prepareStatement(NEWCOMPUTER);			
			preparedStatement.setString(1, computerDto.getNameDto());
			computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto());
			
			if (computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()).isPresent()) {
				Timestamp intro = computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()).get();
				preparedStatement.setTimestamp(2, intro);				
			}	
			
			if (computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()).isPresent()) {
				Timestamp disco = computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()).get();
				preparedStatement.setTimestamp(3, disco);			
			}  
			
			preparedStatement.setInt(4, computerDto.getCompanyDto().getIdDto());
			preparedStatement.executeUpdate();			
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Optional<Computer> showComputerDetail(int idComputer) {
		Computer computerDetail = new Computer();
		Company company = new Company();
		ComputerMapper computerMapper = new ComputerMapper();
		if (idComputer == 0) {
			return Optional.empty();
		}

		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FINDCOMPUTERBYID);	
			preparedStatement.setInt(1, idComputer);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				Optional<LocalDate> introduced = computerMapper
						.convertTimeSteamToLocalDate(resultset.getTimestamp("introduced"));
				Optional<LocalDate> discontinued = computerMapper
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
			
			e.printStackTrace();
		}
		return Optional.of(computerDetail);
	}

	public void deleteComputer(int id) {
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETEIDCOMPUTER);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateComputer(ComputerDto computerDto) {
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATECOMPUTERBYID);
			preparedStatement.setString(1, computerDto.getNameDto());
			if (computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()).isPresent()) {
				Timestamp intro = computerMapper.convertStringToTImeSteam(computerDto.getIntroducedDto()).get();
				preparedStatement.setTimestamp(2, intro);
			}

			if (computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()).isPresent()) {
				Timestamp disco = computerMapper.convertStringToTImeSteam(computerDto.getDiscontinuedDto()).get();
				preparedStatement.setTimestamp(3, disco);
			}

			preparedStatement.setInt(4, computerDto.getCompanyDto().getIdDto());
			preparedStatement.setInt(5, computerDto.getIdDto());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Computer> findByName(String nameComputer) {
		
		Company company = new Company();
		List<Computer> listComputer = new ArrayList<Computer>();		
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME);			
			preparedStatement.setString(1, nameComputer);
			ResultSet resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				int idShow = resultset.getInt("id");				
				String nameComputerShow = resultset.getString("cpt.name");
				Timestamp introducedShow = resultset.getTimestamp("cpt.introduced");
				Timestamp discontinuedShow = resultset.getTimestamp("cpt.discontinued");
				int companyIdShow = resultset.getInt("cpt.company_id");
				String nameCompany = resultset.getString("cpn.name");
				Computer computer = new Computer();
				computer.setId(idShow);
				computer.setName(nameComputerShow);
				computer.setIntroduced(computerMapper.convertTimeSteamToLocalDate(introducedShow));
				computer.setDiscontinued(computerMapper.convertTimeSteamToLocalDate(discontinuedShow));
				company.setId(companyIdShow);
				company.setName(nameCompany);				
				computer.setCompagnie(company);
				listComputer.add(computer);					
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return listComputer;		
	}

}

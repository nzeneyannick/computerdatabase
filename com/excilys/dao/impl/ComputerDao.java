package com.excilys.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.excilys.dao.IComputerDao;
import com.excilys.entities.Company;
import com.excilys.entities.Computer;

public class ComputerDao implements IComputerDao {
	private static Connection con;
	Statement statement;
	ResultSet resultset;
	private static final String LISTOFCOMPUTER = "select cpt.id, cpt.name, cpt.introduced,cpt.discontinued,cpt.company_id  from company cpn inner join computer cpt on cpn.id=cpt.company_id limit 10;\n ";
	private static final String NEWCOMPUTER = "INSERT INTO computer(name,introduced, discontinued,company_id ) VALUES (?,?,?,?);";
	private static final String findByIDComputer = "select id, name, introduced, discontinued,company_id from computer where id=?";

	public ComputerDao() {
		super();
		getConnection();
	}

	public void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/computer-database-db ", "admincdb",
					"qwerty1234");
			// Do something with the connection
			System.out.println(" ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			e.getMessage();

		} catch (Exception e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
	}

	@Override
	public List<Computer> getListComputer() {
		List<Computer> list = new ArrayList<Computer>();
		try {
			statement = con.createStatement();
			// execution de la requette
			resultset = statement.executeQuery(LISTOFCOMPUTER);

			// recuperation des données
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
				computer.setIntroduced(introduced);
				computer.setDiscontinued(discontinued);

				company.setId(companyId);

				computer.setCompagnie(company);

				list.add(computer);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			// Fermeture de la connexion
			try {
				if (resultset != null)
					resultset.close();
				if (statement != null)
					statement.close();
				if (con != null)
					con.close();
			} catch (SQLException ignore) {
			}
		}
		return list;
	}

	@Override
	public void createComputer(Computer computer) {

		try {
			PreparedStatement preparedStatement = con.prepareStatement(NEWCOMPUTER);
			preparedStatement.setString(1, computer.getName());
			preparedStatement.setTimestamp(2, computer.getIntroduced());
			preparedStatement.setTimestamp(3, computer.getDiscontinued());
			preparedStatement.setInt(4, computer.getCompagnie().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Computer showComputerDetail(int idComputer) {
		Computer computerDetail = new Computer();
		Company company = new Company();

		try {
			PreparedStatement preparedStatement = con.prepareStatement(findByIDComputer);
			// Trie effectué sur l'id du computer
			preparedStatement.setInt(1, idComputer);
			// recuperation des données
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				Timestamp introduced = resultset.getTimestamp("introduced");
				Timestamp discontinued = resultset.getTimestamp("discontinued");
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
		} finally {
			// Fermeture de la connexion
			try {
				if (resultset != null)
					resultset.close();
				if (statement != null)
					statement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.getStackTrace();
			}
		}
		return computerDetail;
	}

	@Override
	public void deleteComputer(int id) {
		// TODO Auto-generated method stub

	}

}

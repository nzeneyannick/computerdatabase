package com.excilys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.excilys.entities.Company;
import com.excilys.entities.Computer;

public class ComputerDao implements IComputerDao {
	private Connection con;

	public ComputerDao() {
		super();
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
		Statement statement = null;
		ResultSet resultset = null;
		try {
			statement = con.createStatement();
			// execution de la requette
			// resultset = statement.executeQuery("select cpn.id from company cpn inner join
			// computer cpt on cpn.id=cpt.company_id; \n" +
			// "");
			resultset = statement.executeQuery(
					"select cpt.id, cpt.name, cpt.introduced,cpt.discontinued,cpt.company_id  from company cpn inner join computer cpt on cpn.id=cpt.company_id limit 10;\n ");

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

}

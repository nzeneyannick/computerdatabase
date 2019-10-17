package com.excilys.cdb.utils;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {

	private static HikariDataSource dataSource;

	static {
		try {

			dataSource = new HikariDataSource();
			ResourceBundle r = ResourceBundle.getBundle("db");
			dataSource.setDriverClassName(r.getString("NomDriver"));
			dataSource.setUsername("login");

			dataSource.setDriverClassName(r.getString("NomDriver"));
			dataSource.setDriverClassName(r.getString("NomDriver"));
			String db_driver = r.getString("NomDriver");
			String db_url = r.getString("url");
			String db_username = r.getString("login");
			String db_password = r.getString("pwd");

			dataSource.setDriverClassName(db_driver);
			dataSource.setJdbcUrl(db_url);
			dataSource.setUsername(db_username);
			dataSource.setPassword(db_password);

			dataSource.setMinimumIdle(100);
			dataSource.setMaximumPoolSize(2000);// The maximum number of connections, idle or busy, that can be present
												// in the pool.
			dataSource.setAutoCommit(false);
			dataSource.setLoginTimeout(3);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;

	}

}
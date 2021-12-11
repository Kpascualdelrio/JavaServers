package com.conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class dataSourceJDBC {
	private DriverManagerDataSource dataSource = new DriverManagerDataSource();

	private final String url = "jdbc:mysql://127.0.0.1:3306/ong_sonrisas_por_el_mundo?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final String dbUsername = "root";
	private final String dbPassword = "Uoc1733cr";

	public dataSourceJDBC() {
		dataSource.setUrl(url);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
	}

	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}
}

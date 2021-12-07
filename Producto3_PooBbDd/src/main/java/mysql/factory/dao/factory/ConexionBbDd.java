package mysql.factory.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import mysql.factory.MysqlSocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBbDd {

	// Librería de MySQL
	public String driver = "com.mysql.cj.jdbc.Driver";

	// Nombre de la base de datos
	public String database = "ONG";

	// Host
	public String hostname = "localhost";

	// Puerto
	public String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=UTC";
	//"jdbc:mysql://localhost:3306/ONG","root", "hola123"
	// Nombre de usuario
	public String username = "root";

	// Clave de usuario
	public String password = "hola123";

	public Connection conectarMySQL() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conexion correcta");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("error conexion");
		}

		return conn;
	}

}

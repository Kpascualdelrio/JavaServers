package mysql.factory.dao.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ClasesConJAXB.Socio;

import mysql.factory.MysqlEquipo;
import mysql.factory.MysqlOng;
import mysql.factory.MysqlProyecto;
import mysql.factory.MysqlSocio;

public class MysqlInstances {
	final String GETSOOCIO = "SELECT namePartner, lastNamePartner  WHERE idPartner=? ";
	private Connection conn;
	

	private Socio convert(ResultSet rs) throws SQLException {

		String idPartner = rs.getString("idPartner");
		String namePartner = rs.getString("namePartner");
		String lastNamePartner = rs.getString("lastNamePartner");
		Socio socio = new Socio(idPartner, namePartner, lastNamePartner);
		return socio;
	}

	public Socio getSocio(String idPartner, String namePartner, String lastNamePartner) throws Exception {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Socio socio = null;
		if (idPartner.equals(idPartner)) {

			try {
				stat = conn.prepareStatement(GETSOOCIO);
				stat.setString(1, idPartner);
				rs = stat.executeQuery();
				if (rs.next()) {

					socio = convert(rs);
				} else {
					throw new Exception("No tienes socios con ese id ");
				}

			} catch (Exception e) {
				throw new Exception("Error en SQL", e);
			}
			try {

				try {
					stat = conn.prepareStatement(GETSOOCIO);
				} catch (SQLException ex) {
					throw new Exception("Error en SQL ", ex);
				}
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						throw new Exception("Error en SQL", e);
					}
				}
				if (stat != null) {
					try {
						stat.close();
					} catch (SQLException e) {
						throw new Exception("Error en SQL", e);
					}
				}
			}

		}
		return new Socio();

	}
}

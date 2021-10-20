package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Socio;
import dao.Daoexceptions;
import dao.Sociodao;

public class Mysqlsocio implements Sociodao {

	final String INSERT = "INSERT INTO Socio(idPartner,namePartner,lastNamePartner) VALUES(?,?,?) ON DUPLICATE KEY UPDATE idPartner=idPartner, namePartner=namePartner,lastNamePartner=lastNamePartner";
	final String UPDATE = "UPDATE Socio SET namePartner=? lastNamePartner=? WHERE idPartner=? ";
	final String DELETE = "DELETE FROM Socio WHERE idPartner=? ";
	final String GETPARTNERS = "SELECT idPartner,namePartner, lastNamePartner FROM Socio";
	final String GETSOOCIO = "SELECT namePartner, lastNamePartner  WHERE idPartner=? ";
	private Connection conn;

	public Mysqlsocio(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Socio socio) throws Daoexceptions {

		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(INSERT);
			stat.setString(1, socio.getIdPartner());
			stat.setString(2, socio.getNamePartner());
			stat.setString(3, socio.getLastNamePartner());
			if (stat.executeUpdate() == 0) {
				throw new Daoexceptions("No se han podido insertar los datos correctamente");
			} else {
				System.out.println("Datos introducidos correctamente: " + socio.toString());
			}
		} catch (SQLException ex) {
			throw new Daoexceptions("Error en SQL ", ex);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new Daoexceptions("Error en SQL ", ex);
				}
			}
		}
	}

	// método que toma los datos de la base de datos y los convierte en objeto
	// operacion
	private Socio convert(ResultSet rs) throws SQLException {

		String idPartner = rs.getString("idPartner");
		String namePartner = rs.getString("namePartner");
		String lastNamePartner = rs.getString("lastNamePartner");
		Socio socio = new Socio(idPartner, namePartner, lastNamePartner);
		return socio;
	}

	@Override
	public void modificar(Socio socio) throws Daoexceptions {
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, socio.getIdPartner());
			stat.setString(2, socio.getNamePartner());
			if (stat.executeUpdate() == 0) {
				throw new Daoexceptions("No se han podido modificar los datos");
			} else {
				System.out.println("Cambios aplicados correctamente");
			}
		} catch (SQLException ex) {
			throw new Daoexceptions("Error en SQL ", ex);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new Daoexceptions("Error en SQL ", ex);
				}
			}
		}
	}

	@Override
	public void eliminar(Socio socio) throws Daoexceptions {
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(DELETE);
			stat.setString(1, socio.getIdPartner());
			stat.setString(2, socio.getNamePartner());
			stat.setString(3, socio.getLastNamePartner());
			if (stat.executeUpdate() == 0) {
				throw new Daoexceptions("No se han podido elminar los datos");
			} else {
				System.out.println("Datos eliminados correctamente");
			}
		} catch (SQLException ex) {
			throw new Daoexceptions("Error en SQL ", ex);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new Daoexceptions("Error en SQL ", ex);
				}
			}
		}

	}

	@Override
	public List<Socio> obtenerTodos() throws Daoexceptions {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Socio> socios = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETPARTNERS);
			rs = stat.executeQuery();
			while (rs.next()) {
				socios.add(convert(rs));
			}

		} catch (SQLException e) {
			throw new Daoexceptions("Error en SQL", e);
		}
		try {

			try {
				stat = conn.prepareStatement(GETPARTNERS);
			} catch (SQLException ex) {
				throw new Daoexceptions("Error en SQL ", ex);

			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new Daoexceptions("Error en SQL", e);
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new Daoexceptions("Error en SQL", e);

				}
			}
		}

		return socios;
	}

	@Override
	public Socio obtener(String idPartner) throws Exception {

		PreparedStatement stat = null;
		ResultSet rs = null;
		Socio socio = null;
		try {
			stat = conn.prepareStatement(GETSOOCIO);
			stat.setString(1, idPartner);
			rs = stat.executeQuery();
			if (rs.next()) {

				socio = convert(rs);
			} else {
				throw new Daoexceptions("No tienes socios con ese id ");
			}

		} catch (Daoexceptions | SQLException e) {
			throw new Daoexceptions("Error en SQL", e);
		}
		try {

			try {
				stat = conn.prepareStatement(GETSOOCIO);
			} catch (SQLException ex) {
				throw new Daoexceptions("Error en SQL ", ex);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new Daoexceptions("Error en SQL", e);
				}
			}
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new Daoexceptions("Error en SQL", e);
				}
			}
		}

		return socio;
	}

}

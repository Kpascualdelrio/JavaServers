package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Proyecto;
import clases.Socio;
import dao.Daoexceptions;
import dao.Proyectodao;

public class Mysqlproyecto implements Proyectodao {

	final String INSERT = "INSERT INTO Proyecto(idProject,startDate,endDate,funder,financingProvided,projectCode,actionTaken,localPartner) VALUES(?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE "
			+ "idProject=idProject, startDate=startDate,endDate=endDate, funder=funder,financingProvided=financingProvided, "
			+ "projectCode=projectCode,actionTaken=actionTaken,localPartner=localPartner ";

	final String UPDATE = "UPDATE Proyecto SET startDate=?,endDate=?, funder=?,financingProvided=?WHERE idProject=? ";
	final String DELETE = "DELETE FROM Proyecto WHERE idProject=? ";
	final String GETPROJECTS = "SELECT idProject,startDate,endDate,funder,financingProvided,projectCode,actionTaken,localPartner FROM Proyecto";
	final String GETPROJECT = "SELECT startDate,endDate,funder,financingProvided,projectCode,actionTaken,localPartner  WHERE idProject=? ";
	private Connection conn;

	public Mysqlproyecto(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Proyecto proyecto) throws Daoexceptions {
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(INSERT);
			stat.setString(1, proyecto.getIdProject());
			stat.setString(2, proyecto.getStartDate());
			stat.setString(3, proyecto.getEndDate());
			stat.setString(4, proyecto.getFunder());
			stat.setString(5, proyecto.getFinancingProvided());
			stat.setString(6, proyecto.getActionTaken());
			stat.setString(7, proyecto.getProjectCode());
			stat.setString(8, proyecto.getLocalPartner());

			if (stat.executeUpdate() == 0) {
				throw new Daoexceptions("No se han podido insertar los datos correctamente");
			} else {
				System.out.println("Datos introducidos correctamente:" + proyecto.toString());
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

	private Proyecto convert(ResultSet rs) throws SQLException {

		String idProject = rs.getString("idProject");
		String startDate = rs.getString("startDate");
		String endDate = rs.getString("endDate");
		String funder = rs.getString("funder");
		String financingProvided = rs.getString("financingProvided");
		String projectCode = rs.getString("projectCode");
		String actionTaken = rs.getString("actionTaken");
		String localPartner = rs.getString("localPartner");

		// aquí tengo que ver como le paso el objeto socio y el objeto equipo
		Proyecto proyecto = new Proyecto(idProject, null, null, startDate, endDate, funder, financingProvided,
				projectCode, actionTaken, localPartner);
		return proyecto;
	}

	@Override
	public void modificar(Proyecto proyecto) throws Daoexceptions {
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, proyecto.getIdProject());
			stat.setString(2, proyecto.getStartDate());
			stat.setString(3, proyecto.getEndDate());
			stat.setString(4, proyecto.getFunder());
			stat.setString(5, proyecto.getFinancingProvided());
			stat.setString(6, proyecto.getActionTaken());
			stat.setString(7, proyecto.getProjectCode());
			stat.setString(8, proyecto.getLocalPartner());

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
	public void eliminar(Proyecto proyecto) throws Daoexceptions {
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(DELETE);
			stat.setString(1, proyecto.getIdProject());
			stat.setString(2, proyecto.getStartDate());
			stat.setString(3, proyecto.getEndDate());
			stat.setString(4, proyecto.getFunder());
			stat.setString(5, proyecto.getFinancingProvided());
			stat.setString(6, proyecto.getActionTaken());
			stat.setString(7, proyecto.getProjectCode());
			stat.setString(8, proyecto.getLocalPartner());

			if (stat.executeUpdate() == 0) {
				throw new Daoexceptions("No se han podido borrar los datos");
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
	public List<Proyecto> obtenerTodos() throws Daoexceptions {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Proyecto> proyectos = new ArrayList<>();
		try {
			stat = conn.prepareStatement(GETPROJECTS);
			rs = stat.executeQuery();
			while (rs.next()) {
				proyectos.add(convert(rs));
			}

		} catch (SQLException e) {
			throw new Daoexceptions("Error en SQL", e);
		}
		try {

			try {
				stat = conn.prepareStatement(GETPROJECTS);
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

		return proyectos;
	}

	@Override
	public Proyecto obtener(String idProject) throws Exception {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Proyecto proyecto = null;
		try {
			stat = conn.prepareStatement(GETPROJECT);
			stat.setString(1, idProject);
			rs = stat.executeQuery();
			if (rs.next()) {

				proyecto = convert(rs);
			} else {
				throw new Daoexceptions("No tienes socios con ese id ");
			}

		} catch (Daoexceptions | SQLException e) {
			throw new Daoexceptions("Error en SQL", e);
		}
		try {

			try {
				stat = conn.prepareStatement(GETPROJECT);
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

		return proyecto;
	}

}

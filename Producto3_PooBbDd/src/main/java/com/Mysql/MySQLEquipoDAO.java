package com.Mysql;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ClasesConJAXB.Equipo;
import com.Dao.DaoEquipo;
import com.conexion.dataSourceJDBC;

public class MySQLEquipoDAO implements DaoEquipo {

	private boolean contador;
	private dataSourceJDBC mySqlDataSource = new dataSourceJDBC();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());

	@Override
	public void insertar(Equipo equipo) {
		try {
			File fileEquipo = new File("equipos.xml");
			JAXBContext ctx = JAXBContext.newInstance(Equipo.class);
			Unmarshaller ums = ctx.createUnmarshaller();

			Equipo datosEquipo = (Equipo) ums.unmarshal(fileEquipo);

			List<Equipo> listaEquipos = datosEquipo.getEquipos();
			for (Equipo equipos : listaEquipos)// for (equipo equipos; equipo < ListaEquipos; equipos ++)
			{
				if (equipo.getIdTeam() == equipos.getIdTeam()) {
					// Insertamos el objet)o pasado en la base de datos
					jdbcTemplate.update("INSERT INTO equipo( id, nameTeam, nameMember) VALUES(?, ?, ?)",
							equipo.getIdTeam(), equipo.getTeamName(), equipo.getMemberName());

					System.out.println("---------- " + equipo.getTeamName() + " se ha creado." + "con el miembro "
							+ equipo.getMemberName() + "");
					contador = true;
				}

			}
			if (contador == false) {
				System.out.println("\nERROR: \n El Equipo: " + equipo.getIdTeam() + " Con el miembro: "
						+ equipo.getMemberName()
						+ " no se puede introducir puesto que no existe en el archivo XML.\n Por favor, añada primero al archivo");

			}

			// en caso de repetirse el objeto, escribe mensaje por pantalla avisando.
		} catch (DataIntegrityViolationException esql) {
			System.out.println(" " + equipo.getMemberName() + " ya existe.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
	}

	@Override
	public void modificar(Equipo equipo) throws JAXBException {

		try {
			// Guardamos el nombre del equipo que exista en la base de datos de nuestro
			// Equipo, correspondiente al id de este.
			String nombreBase = jdbcTemplate.queryForObject("SELECT nameTeam FROM equipo WHERE id = ?;", String.class,
					equipo.getIdTeam());

			// Asignamos el valor del Id, mediante el query a sql, del equipo que nos
			// interese
			int equipoId = jdbcTemplate.queryForObject("SELECT id FROM equipo WHERE id = ?;", Integer.class,
					equipo.getIdTeam());

			// Solo modificamos el nombre del equipo como prueba, si quisieramos modificar
			// mas, creariamos sentencia if y comparariamos valores previos y actuales de
			// los atributos despues de las modificaciones en el MAIN.
			jdbcTemplate.update("UPDATE equipo SET nameTeam = ? WHERE id = ?;", equipo.getTeamName(), equipoId);

			// Imprime por pantalla las modificación realizadas en el nombre del equipo.
			// Imprimimos la variable nombreBase para asegurarnos siempre de que conseguimos
			// el nombre del equipo de la BBDD
			System.out
					.println("---------- El equipo: " + nombreBase + " ahora se llama: " + equipo.getTeamName() + ".");

		} catch (DataIntegrityViolationException esql) {
			System.out.println("El nombre de empresa " + equipo.getTeamName() + " ya existe.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
	}

	@Override
	public void eliminar(Equipo equipo) throws JAXBException {
		try {

			// Asignamos el valor del Id, mediante el query a sql, del equipo que nos
			// interese
			int equipoId = jdbcTemplate.queryForObject("SELECT id FROM equipo WHERE nameTeam = ?;", Integer.class,
					equipo.getTeamName());

			// Eliminamos la fila del id del equipo guardada.
			jdbcTemplate.update("DELETE FROM equipo WHERE id = ?;", equipoId);

			// Imprime por pantalla que se ha eliminado correctamente
			System.out.println("EL equipo: " + equipo.getPrevNameTeam() + "ha sido eliminado correctamente");

		} catch (DataIntegrityViolationException esql) {
			System.out.println("El equipo:  " + equipo.getTeamName() + " no existe, no se puede eliminar.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}

	}
	@Override

	public void obtenerTodosEquipo() {
		
			List<Map<String, Object>> rows = (List<Map<String, Object>>)
			jdbcTemplate.queryForList("SELECT * FROM equipo ORDER BY id ASC");
			rows.forEach(System.out::println);
			
	}

}

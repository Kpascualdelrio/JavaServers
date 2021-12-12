package com.Mysql;

import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ClasesConJAXB.Proyecto;
import com.ClasesConJAXB.Socio;
import com.Dao.DaoProyecto;
import com.conexion.dataSourceJDBC;

public class MysSQLProyectoDao implements DaoProyecto {

	private dataSourceJDBC mySqlDataSource = new dataSourceJDBC();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());

	@Override
	public void insertar(Proyecto proyecto) throws JAXBException {

		try {
			// Insertamos el objeto pasado en la base de datos
			jdbcTemplate.update("INSERT INTO proyecto(idProject,socio,equipo,startDate,endDate,funder,financingProvided,projectCode,actionTaken,localPartner) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					proyecto.getIdProject(),proyecto.getSocio(),proyecto.getEquipo(),proyecto.getStartDate(),proyecto.getEndDate(),proyecto.getFunder(),proyecto.getFinancingProvided(),proyecto.getProjectCode(),proyecto.getActionTaken(), proyecto.getLocalPartner()	);

			System.out.println("---------- " + " se ha creado" + " el proyecto : "+ proyecto.toString());

			// en caso de repetirse el objeto, escribe mensaje por pantalla avisando.
		} catch (DataIntegrityViolationException esql) {
			System.out.println("El proyecto " + proyecto.toString() + " ya existe.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
	}

	@Override
	public void modificar(Proyecto proyecto) throws JAXBException {
		try {
			// Guardamos el nombre del proyecto que exista en la base de datos de nuestro
			// Proyecto, correspondiente al id de este.
			String nombreBase = jdbcTemplate.queryForObject("SELECT equipo FROM proyecto WHERE id = ?;", String.class,
					proyecto.getEquipo());

			// Asignamos el valor del Id, mediante el query a sql, del proyecto que nos
			// interese
			int proyectoId = jdbcTemplate.queryForObject("SELECT id FROM proyecto WHERE id = ?;", Integer.class,
					proyecto.getEquipo());

			// Solo modificamos el nombre del equipo como prueba, si quisieramos modificar
			// mas, creariamos sentencia if y comparariamos valores previos y actuales de
			// los atributos despues de las modificaciones en el MAIN.
			jdbcTemplate.update("UPDATE proyecto SET equipo = ? WHERE id = ?;", proyecto.getEquipo(), proyectoId);

			// Imprime por pantalla las modificación realizadas en el nombre del equipo.
			// Imprimimos la variable nombreBase para asegurarnos siempre de que conseguimos
			// el nombre del equipo de la BBDD
			System.out
					.println("---------- El proyecto: " + nombreBase + " lo forma el equipo: " + proyecto.getEquipo() + ".");

		} catch (DataIntegrityViolationException esql) {
			System.out.println("El nombre del proyecto " + proyecto.getEquipo() + " ya existe.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
		
		
	}

	@Override
	public void eliminar(Proyecto proyecto) throws JAXBException {
		try {

			// Asignamos el valor del Id, mediante el query a sql, del proyectoo que nos
			// interese
			int proyectoId = jdbcTemplate.queryForObject("SELECT id FROM proyecto WHERE equipo = ?;", Integer.class,
					proyecto.getEquipo());

			// Eliminamos la fila del id del proyecto guardada.
			jdbcTemplate.update("DELETE FROM proyecto WHERE id = ?;", proyectoId);

			// Imprime por pantalla que se ha eliminado correctamente
			System.out.println("EL proyecto: " + proyecto.getEquipo() + "ha sido eliminado correctamente");

		} catch (DataIntegrityViolationException esql) {
			System.out.println("El proyecto:  " + proyecto.getEquipo() + " no existe, no se puede eliminar.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
		
	}

	@Override
	public void obtenerTodosProyecto() {
		List<Map<String, Object>> rows = (List<Map<String, Object>>)
				jdbcTemplate.queryForList("SELECT * FROM proyecto ORDER BY id ASC");
				rows.forEach(System.out::println);
				
		
	} 

}

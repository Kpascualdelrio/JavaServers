package com.Mysql;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Socio;

import com.Dao.DaoSocio;
import com.conexion.dataSourceJDBC;

public class MySQLSocioDAO implements DaoSocio {
	
	private Boolean contador;
	private dataSourceJDBC mySqlDataSource = new dataSourceJDBC();
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());

	@Override
	public void insertar(Socio socio) {
		try {
			File fileSocio = new File("socios.xml");
			JAXBContext ctx = JAXBContext.newInstance(Socio.class);
			Unmarshaller ums = ctx.createUnmarshaller();

			Socio datosSocio = (Socio) ums.unmarshal(fileSocio);

			List<Socio> listaSocios = datosSocio.getSocios();
			for (Socio socios : listaSocios) {
				if (socio.getIdPartner() == socios.getIdPartner()) {
			// Insertamos el objeto pasado en la base de datos
			jdbcTemplate.update("INSERT INTO socio( idPartner, namePartner, lastNamePartner) VALUES(?, ?, ?)",
					socio.getIdPartner(), socio.getNamePartner(), socio.getLastNamePartner());

			System.out.println("---------- " + " se ha creado." + "el socio " + socio.getNamePartner() + " "
					+ socio.getLastNamePartner());
			contador = true;
				}
			}
			
			if (contador == false) {
				System.out.println("\nERROR: \n El Socio: "+socio.getIdPartner()+ " "+ socio.getLastNamePartner() + "no se puede introducir puesto que no existe en el archivo XML.\n Por favor, añada primero al archivo");
				
			}
			// en caso de repetirse el objeto, escribe mensaje por pantalla avisando.
		} catch (DataIntegrityViolationException esql) {
			System.out.println("El socio " + socio.getNamePartner() + " " + socio.getLastNamePartner() + " ya existe.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
	}

	@Override
	public void modificar(Socio socio) throws JAXBException {
		
		try {
			// Guardamos el nombre del socio que exista en la base de datos de nuestro
			// Socio, correspondiente al id de este.
			String nombreBase = jdbcTemplate.queryForObject("SELECT lastNamePartner FROM socio WHERE idPartner = ?;", String.class,
					socio.getIdPartner());

			// Asignamos el valor del Id, mediante el query a sql, del socio que nos
			// interese
			int socioId = jdbcTemplate.queryForObject("SELECT idPartner FROM socio WHERE idPartner = ?;", Integer.class,
					socio.getIdPartner());

			// Solo modificamos el nombre del socio como prueba, si quisieramos modificar
			// mas, creariamos sentencia if y comparariamos valores previos y actuales de
			// los atributos despues de las modificaciones en el MAIN.
			jdbcTemplate.update("UPDATE socio SET lastNamePartner = ? WHERE idPartner = ?;", socio.getLastNamePartner(), socioId);

			// Imprime por pantalla las modificación realizadas en el nombre del socio.
			// Imprimimos la variable nombreBase para asegurarnos siempre de que conseguimos
			// el nombre del socio de la BBDD
			System.out
					.println("---------- El socio: " + socio.getNamePartner()+ " "+ nombreBase + " ahora se apellida: " + socio.getLastNamePartner() + ".");

		} catch (DataIntegrityViolationException esql) {
			System.out.println("El nombre del socio " + socio.toString() + " ya existe.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}
	}
	
	@Override
	public void eliminar(Socio socio) throws JAXBException {
		try {

			// Asignamos el valor del Id, mediante el query a sql, del socio que nos
			// interese
			int socioId = jdbcTemplate.queryForObject("SELECT idPartner FROM socio WHERE namePartner = ?;", Integer.class,
					socio.getNamePartner());

			// Eliminamos la fila del id del socio guardada.
			jdbcTemplate.update("DELETE FROM socio WHERE idPartner = ?;", socioId);

			// Imprime por pantalla que se ha eliminado correctamente
			System.out.println("EL socio: " + socio.getNamePartner() + "ha sido eliminado correctamente");

		} catch (DataIntegrityViolationException esql) {
			System.out.println("El equipo:  " + socio.getNamePartner() + " no existe, no se puede eliminar.");

		} catch (Exception exception) {
			System.out.println("*** ERROR: " + exception.getMessage() + " ***");
		}

	}

	@Override
	public void obtenerTodosSocio() {
		List<Map<String, Object>> rows = (List<Map<String, Object>>)
				jdbcTemplate.queryForList("SELECT * FROM socio ORDER BY idPartner ASC");
				rows.forEach(System.out::println);
				
		
	}
} 

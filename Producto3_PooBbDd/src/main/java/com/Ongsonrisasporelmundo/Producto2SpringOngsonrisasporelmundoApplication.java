package com.Ongsonrisasporelmundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.xml.sax.SAXException;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.ONG;
import com.ClasesConJAXB.Proyecto;
import com.ClasesConJAXB.Socio;
import com.Dao.Dao;
import com.Dao.DaoEquipo;
import com.Dao.DaoProyecto;
import com.Dao.DaoSocio;
import com.Dao.XmlDaoEquipo;
import com.Dao.XmlDaoProyecto;
import com.Dao.XmlDaoSocio;
import com.Mysql.MySQLDaoFactory;
import com.Mysql.MySQLEquipoDAO;
import com.Mysql.MySQLSocioDAO;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })

public class Producto2SpringOngsonrisasporelmundoApplication {

	private static ONG ong;
	private static Equipo equipo;
	private static Equipo equipoMedico;
	private static Equipo equipoEnfermeria;
	private static Equipo equipoJefe;
	private static Equipo equipoProyectos;
	private static Equipo equipoMarketing;
	private static Equipo equipoMarketing2;
	private static Equipo equipoEnfermeria2;

	private static Socio BBVA;
	private static Socio Caixa;
	private static Socio ING;
	private static Socio socio;

	private static Proyecto proyecto;
	private static Proyecto proyectoCongoMalaria;
	private static Proyecto proyectoHaitiSida;

	private static ONG inicializaOng() {
		ong = new ONG("01", "Sonrisas01");

		return ong;
	}

	private static Equipo inicializaEquipo() {
		equipoMedico = new Equipo("TeamUSA", "Kevin Pascual");
		equipoEnfermeria = new Equipo("TeamEU", "Jose");
		equipoJefe = new Equipo("TeamUK", "Mati");
		equipoProyectos = new Equipo("TeamES", "Adri");
		equipoMarketing = new Equipo("teamMA", "Naila");
		equipoMarketing2 = new Equipo("teamMA", "Kevin Pascual");
		equipoEnfermeria2 = new Equipo("TeamEU", "Jose");

		Equipo equipo = new Equipo();
		equipo.add(equipoMedico);
		equipo.add(equipoEnfermeria);
		equipo.add(equipoJefe);
		equipo.add(equipoProyectos);
		equipo.add(equipoMarketing);

		return equipo;

	}

	private static Socio inicializaSocios() {

		BBVA = new Socio("Kevin", "Pascual");
		Caixa = new Socio("Marcos", "Pascual");
		ING = new Socio("Alejandro", "Salhi");
		Socio socio = new Socio();
		socio.add(BBVA);
		socio.add(Caixa);
		socio.add(ING);

		return socio;

	}

	private static Proyecto inicializaProyectos() {

		// String socio1 = BBVA.toString();
		proyectoCongoMalaria = new Proyecto(BBVA, equipoMedico, "2021-10-05", "2024-10-05", "UOC", "200.00",
				"2021/2024", "Lucha contra la malaria", "Fe y alegria");
		proyectoHaitiSida = new Proyecto(Caixa, equipoEnfermeria, "2022-10-05", "2025-10-05", "UOC", "150.00",
				"2021/2025", "Lucha contra el sida", "Parroquia San Antonio");

		Proyecto proyecto = new Proyecto();
		proyecto.add(proyectoCongoMalaria);
		proyecto.add(proyectoHaitiSida);

		return proyecto;

	}

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Producto2SpringOngsonrisasporelmundoApplication.class, args);
		ong = inicializaOng();
		equipo = inicializaEquipo();
		socio = inicializaSocios();
		proyecto = inicializaProyectos();

		/*-----------------------------------INICIO Operaciones con la CLASE EQUIPO-------------------------------------------------*/

		System.out.println("PASO1: ");
		/*------------Crea archivo XML del los Objetos instanciados en la clase EQUIPO--------------------*/
		Dao XmlDAO = Dao.getDAO(Dao.XML);
		XmlDAO.insertarEquipo().insertar(equipo);

		System.out.println("-----Fin de generación del archivo XML----\n");

		System.out.println("PASO2: ");
		/*------------Introduce los objetos instanciados en MYSQL ( En funcion de si existen o no en el XML previo)--------------------*/
		System.out.println("----Procediendo a cargar traspaso Equipos a MYSQL Workbench----");
		System.out.println("Generando Solicitud para añadir a la base de datos....");

		Dao mysqlDAO = Dao.getDAO(Dao.MYSQL);

		for (Equipo eq : equipo.getEquipos()) {
			mysqlDAO.insertarEquipo().insertar(eq);
		}

		System.out.println("----Fin de Carga a MYSQL Workbench----\n");

//		mysqlDAO.insertarEquipo().insertar(equipoMarketing2); --para que salte la excepción : no existe en el XML

		System.out.println("PASO3: ");
		/*--------------Modificar objetos en Mysql--------------------------------------*/
		System.out.println("----Inicio Modificacion en MYSQL ----");
		System.out.println("Generando Solicitud en la base de datos....");

		equipoMedico.setTeamName("TeamModificación");// modificamos el atributo para actualizar nuestra BBDD
		mysqlDAO.modificarEquipo().modificar(equipoMedico);

		System.out.println("----Fin de modificacion en MYSQL Workbench----\n");

		System.out.println("PASO4: ");
		/*--------------Eliminar objetos en Mysql--------------------------------------*/
		System.out.println("----Inicio Eliminación en MYSQL ----");
		System.out.println("Generando Solicitud en la base de datos....");

		mysqlDAO.eliminarEquipo().eliminar(equipoMarketing);

		System.out.println("----Fin de eliminación en MYSQL Workbench----\n");

		System.out.println("PASO5: ");
		/*--------------Obtener tabla Equipo de Mysql--------------------------------------*/
		System.out.println("----Inicio Obtencion datos tabla Equipo de MYSQL ----");
		System.out.println("Generando Solicitud en la base de datos....");

		mysqlDAO.obtenerTodos().obtenerTodosEquipo();

		System.out.println("----Fin de eliminación en MYSQL Workbench----\n");

		/*-----------------------------------FIN Operaciones con la CLASE EQUIPO-------------------------------------------------*/

		
		
		
//		/*-----------------------------------INICIO Operaciones con la CLASE SOCIO-------------------------------------------------*/
//
//		System.out.println("PASO1: ");
//		/*------------Crea archivo XML del los Objetos instanciados en la clase SOCIO-------------------*/
//		Dao XmlDAO_02 = Dao.getDAO(Dao.XML);
//		XmlDAO_02.insertaSocio().insertar(socio);
//
//		System.out.println("-----Fin de generación del archivo XML----\n");
//
//		System.out.println("PASO2: ");
//		/*------------Introduce los objetos instanciados en MYSQL ( En funcion de si existen o no en el XML previo)--------------------*/
//		System.out.println("----Procediendo a cargar traspaso de Socios a MYSQL Workbench----");
//		System.out.println("Generando Solicitud para añadir a la base de datos....");
//
//		Dao mysqlDAO_02 = Dao.getDAO(Dao.MYSQL);
//
//		for (Socio soc : socio.getSocios()) {
//			mysqlDAO_02.insertaSocio().insertar(soc);
//		}
//
//		System.out.println("----Fin de Carga a MYSQL Workbench----\n");
//
//		System.out.println("PASO3: ");
//		/*--------------Modificar objetos en Mysql--------------------------------------*/
//		System.out.println("----Inicio Modificacion en MYSQL ----");
//		System.out.println("Generando Solicitud en la base de datos....");
//
//		BBVA.setLastNamePartner("ApellidoModificado");// modificamos el atributo para actualizar nuestra BBDD
//		mysqlDAO_02.modificarSocio().modificar(BBVA);
//
//		System.out.println("----Fin de modificacion en MYSQL Workbench----\n");
//
//		System.out.println("PASO4: ");
//		/*--------------Eliminar objetos en Mysql--------------------------------------*/
//		System.out.println("----Inicio Eliminación en MYSQL ----");
//		System.out.println("Generando Solicitud en la base de datos....");
//
//		mysqlDAO_02.eliminarSocio().eliminar(ING);
//
//		System.out.println("----Fin de eliminación en MYSQL Workbench----\n");
//
//		System.out.println("PASO5: ");
//		/*--------------Obtener tabla Socio de Mysql--------------------------------------*/
//		System.out.println("----Inicio Obtencion datos tabla Socio de MYSQL ----");
//		System.out.println("Generando Solicitud en la base de datos....");
//
//		mysqlDAO_02.obtenerTodosSocio().obtenerTodosSocio();
//
//		System.out.println("----Fin de eliminación en MYSQL Workbench----\n");
//
//		/*-----------------------------------FIN Operaciones con la CLASE SOCIO-------------------------------------------------*/

		
		
		
	}
}

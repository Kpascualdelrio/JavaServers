package com.Ongsonrisasporelmundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xml.sax.SAXException;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.ONG;
import com.ClasesConJAXB.Proyecto;
import com.ClasesConJAXB.Socio;
import com.Dao.Dao;
import com.Dao.XmlDaoEquipo;
import com.Dao.XmlDaoProyecto;
import com.Dao.XmlDaoSocio;

import mysql.factory.MysqlSocio;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

@SpringBootApplication
public class Producto2SpringOngsonrisasporelmundoApplication {

	private static ONG ong;
	private static Equipo equipo;
	private static Equipo equipoMedico;
	private static Equipo equipoEnfermeria;

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
		equipoMedico = new Equipo("EMCM", ong, "TeamUSA", "teamUSA");
		equipoEnfermeria = new Equipo("EEHS", ong, "TeamEU", "teamEU");

		Equipo equipo = new Equipo();
		equipo.add(equipoMedico);
		equipo.add(equipoEnfermeria);

		return equipo;

	}

	private static Socio inicializaSocios() {

		BBVA = new Socio("01", "Kevin", "Pascual");
		Caixa = new Socio("02", "Marcos", "Pascual");
		//ING = new Socio("03", "Alejandro", "Salhi");
		Socio socio = new Socio();
		socio.add(BBVA);
		socio.add(Caixa);
		//socio.add(ING);

		

		return socio;

	}
	private static Proyecto inicializaProyectos() {
		
		
		
		proyectoCongoMalaria = new Proyecto("LM/21/24", BBVA, equipoMedico,"2021-10-05","2024-10-05","UOC","200.00","2021/2024","Lucha contra la malaria","Fe y alegria");
		proyectoHaitiSida = new Proyecto("LS/22/25", Caixa, equipoEnfermeria,"2022-10-05","2025-10-05","UOC","150.00","2021/2025","Lucha contra el sida","Parroquia San Antonio");

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
		proyecto=inicializaProyectos();
		Connection conn=null;
		conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ONG","root", "hola123");
		//proyectos
		Dao displayProject = Dao.getDAO(Dao.XML);
		XmlDaoProyecto proyectosTest = displayProject.getDaoProyecto();
		//proyectosTest.guardarProyecto(proyecto);
		//proyectosTest.listarProyectos();
		
		//equipos
		Dao displayTeam = Dao.getDAO(Dao.XML);
		XmlDaoEquipo equiposTest = displayTeam.getDaoEquipo();
		//equiposTest.guardarEquipos(equipo);
		//equiposTest.listarEquipos();
		
		//socios
		Dao displaySocio = Dao.getDAO(Dao.XML);
		XmlDaoSocio sociosTest = displaySocio.getDaoSocio();
		sociosTest.guardarSocios(socio);
		sociosTest.listarSocios();
		
		
		//INSTANCIAS DE MYSQL
		
		MysqlSocio socioBbdd= new MysqlSocio(conn);
		
		//socioBbdd.insertar(socio);
		/*for(Socio s:socio.getSocios()) {
			socioBbdd.insertar(s);
		}*/
		

	}
}

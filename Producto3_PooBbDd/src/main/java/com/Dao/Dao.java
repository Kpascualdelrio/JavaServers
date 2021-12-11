package com.Dao;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Equipo;
import com.Mysql.MySQLDaoFactory;



public abstract class Dao{

	public static final int XML = 1;
	public static final int MYSQL = 2; 
	
	public abstract DaoEquipo insertarEquipo() throws JAXBException;
	
	public abstract DaoSocio insertaSocio() throws JAXBException;
	
	public abstract DaoProyecto insertarProyecto() throws JAXBException;
	
	public abstract DaoEquipo modificarEquipo() throws JAXBException;
	
	public abstract DaoSocio modificarSocio() throws JAXBException;

	public abstract DaoProyecto modificarProyecto() throws JAXBException;
	
	public abstract DaoEquipo eliminarEquipo() throws JAXBException;
	
	public abstract DaoSocio eliminarSocio() throws JAXBException;
	
	public abstract DaoProyecto eliminarProyecto() throws JAXBException;
	
	public abstract DaoEquipo obtenerTodos() throws JAXBException;
	
	public abstract DaoSocio obtenerTodosSocio() throws JAXBException;
	
	public abstract DaoProyecto obtenerTodosProyecto() throws JAXBException;

	public static Dao getDAO(int whichFactory) {

		switch (whichFactory) {
		case XML:
			return  new XmlDAO();
		case MYSQL:
		return new MySQLDaoFactory();
		default:
			return null;
		}
	}

	

	

}

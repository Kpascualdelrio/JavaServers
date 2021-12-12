package com.Mysql;

import javax.xml.bind.JAXBException;

import com.Dao.Dao;
import com.Dao.DaoEquipo;
import com.Dao.DaoProyecto;
import com.Dao.DaoSocio;

public class MySQLDaoFactory extends Dao{
	
	
	//----------------Funciones DAO Clase Equipo----------------------------------------------//
	@Override
	public DaoEquipo insertarEquipo() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLEquipoDAO();
	}
	
	@Override
	public DaoEquipo modificarEquipo() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLEquipoDAO();
	}
	
	@Override
	public DaoEquipo eliminarEquipo() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLEquipoDAO();
	}
	
	@Override
	public DaoEquipo obtenerTodos() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLEquipoDAO();
	}
	
//------------------FUNCIONES DAO CLASE SOCIO-------------------------------------------------------------------------//
	@Override
	public DaoSocio insertaSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLSocioDAO();
	}


	@Override
	public DaoSocio modificarSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLSocioDAO();
	}

	//---------------FUNCIONES DAO CLASE PROYECTO-------------------------------------------------------------------------------//
	@Override
	public DaoProyecto insertarProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return new MysSQLProyectoDao();
	}


	@Override
	public DaoProyecto modificarProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return new MysSQLProyectoDao();
	}

	@Override
	public DaoSocio eliminarSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLSocioDAO();
	}

	@Override
	public DaoProyecto eliminarProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return new MysSQLProyectoDao();
	}

	@Override
	public DaoSocio obtenerTodosSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return new MySQLSocioDAO();
	}

	@Override
	public DaoProyecto obtenerTodosProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return new MysSQLProyectoDao();
	}

	


	
}
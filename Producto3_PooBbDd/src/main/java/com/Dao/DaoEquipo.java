package com.Dao;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Equipo;

public interface DaoEquipo {

	void insertar(Equipo equipo) throws JAXBException;

	void modificar(Equipo equipo) throws JAXBException;
	
	void eliminar(Equipo equipo) throws JAXBException;

	void obtenerTodosEquipo();

}

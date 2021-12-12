package com.Dao;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Proyecto;

public interface DaoProyecto {

	void insertar(Proyecto proyecto) throws JAXBException;	
	
	void modificar(Proyecto proyecto) throws JAXBException;

	void eliminar(Proyecto proyecto) throws JAXBException;

	void obtenerTodosProyecto();
}

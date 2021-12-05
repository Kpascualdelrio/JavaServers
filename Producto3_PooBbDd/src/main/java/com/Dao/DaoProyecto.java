package com.Dao;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Proyecto;

public interface DaoProyecto {

	public void guardarProyecto(Proyecto proyecto) throws JAXBException;

	public Proyecto listarProyectos() throws JAXBException;

}

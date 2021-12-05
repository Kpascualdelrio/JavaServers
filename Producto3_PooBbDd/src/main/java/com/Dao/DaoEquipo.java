package com.Dao;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Equipo;

public interface DaoEquipo {

	public void guardarEquipos(Equipo equipo) throws JAXBException;

	public Equipo listarEquipos() throws JAXBException;

}

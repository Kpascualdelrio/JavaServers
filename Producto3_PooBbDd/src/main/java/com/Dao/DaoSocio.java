package com.Dao;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Socio;

public interface DaoSocio {

	void insertar(Socio socio) throws JAXBException;

	void modificar(Socio socio) throws JAXBException;
	
	void eliminar(Socio socio) throws JAXBException;

	void obtenerTodosSocio();

	
	

}
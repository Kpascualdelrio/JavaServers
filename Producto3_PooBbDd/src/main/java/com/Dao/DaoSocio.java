package com.Dao;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Socio;

public interface DaoSocio {

	public void guardarSocios(ArrayList<Socio> socios) throws JAXBException;

	public Socio listarSocios() throws JAXBException;
	void Insertar(Socio socio) throws JAXBException, Exception;

	void modificar(Object a);

	void insertar(Object a) throws Exception, Throwable;

	Object obtener(Object idPartner) throws Exception;

	

}
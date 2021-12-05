package com.Dao;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Socio;

public interface DaoSocio {

	public void guardarSocios(ArrayList<Socio> socios) throws JAXBException;

	public Socio listarSocios() throws JAXBException;

}
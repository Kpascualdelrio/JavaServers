package com.Dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Socio;

import java.io.File;
import java.util.ArrayList;

public class XmlDaoSocio implements DaoSocio {

	private JAXBContext jaxbContext = null;
	private String nombreFichero = null;

	public XmlDaoSocio() throws JAXBException {
		this.jaxbContext = JAXBContext.newInstance(Socio.class);
		this.nombreFichero = "socios.xml";
	}

	@Override
	public void insertar(Socio socio) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(socio, new File(nombreFichero));
		System.out.println("\n\n\n" + "----Generando el archivo XML----\n");
		System.out.println("RESULTADO:");
		System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
		System.out.println("\n");
		marshaller.marshal(socio, System.out);

	}
	
	@Override
	public void modificar(Socio socio) throws JAXBException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void eliminar(Socio socio) throws JAXBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void obtenerTodosSocio() {
		// TODO Auto-generated method stub
		
	}
}

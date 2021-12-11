package com.Dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ClasesConJAXB.Equipo;

import java.io.File;

public class XmlDaoEquipo implements DaoEquipo {

	private JAXBContext jaxbContext = null;
	private String nombreFichero = null;

	public XmlDaoEquipo() throws JAXBException {
		this.jaxbContext = JAXBContext.newInstance(Equipo.class);
		this.nombreFichero = "equipos.xml";
	}

	public void insertar(Equipo equipo) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(equipo, new File(nombreFichero));
		System.out.println("\n" + "----Generando el archivo XML----\n");
		System.out.println("\n" + "------Archivo XML creado--------\n");
		
		/* (OPCION) --> Para comprobar que se crea se muestra el contenido*/
		//System.out.println("RESULTADO:");
		//System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
		//System.out.println("\n");
		//marshaller.marshal(equipo, System.out);
	}

	
	/*Funciones que no utilizamos en XML ya que solo Generamos el Documento*/
	@Override
	public void modificar(Equipo equipo) throws JAXBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Equipo equipo) throws JAXBException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void obtenerTodosEquipo() {
		// TODO Auto-generated method stub
		
	}

}
package com.Dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Proyecto;
import com.ClasesConJAXB.Socio;

public class XmlDaoProyecto implements DaoProyecto{
	private JAXBContext jaxbContext = null;
	private String nombreFichero = null;

	public XmlDaoProyecto() throws JAXBException {
		this.jaxbContext = JAXBContext.newInstance(Proyecto.class);
		this.nombreFichero = "proyectos.xml";
	}

	@Override
	public void insertar(Proyecto proyecto) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(proyecto, new File(nombreFichero));
		System.out.println("\n\n\n" + "----Generando el archivo XML----\n");
		System.out.println("RESULTADO:");
		System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
		System.out.println("\n");
		marshaller.marshal(proyecto, System.out);
		
	}

	/*Funciones que no utilizamos en XML ya que solo Generamos el Documento*/
	@Override
	public void modificar(Proyecto proyecto) throws JAXBException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Proyecto proyecto) throws JAXBException {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void obtenerTodosProyecto() {
		// TODO Auto-generated method stub
		
	}


}

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
	public void guardarProyecto(Proyecto proyecto) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(proyecto, new File(nombreFichero));
		System.out.println();
		System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
		System.out.println();
		marshaller.marshal(proyecto, System.out);
		
	}

	@Override
	public Proyecto listarProyectos() throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Proyecto proyectos = (Proyecto) unmarshaller.unmarshal( new File(nombreFichero) );
	    
		System.out.println();
		System.out.println("Estos son los proyectos contenidos en el fichero " + nombreFichero);
		
	
	
	for(Proyecto proyecto : proyectos.getProyectos())
    {
    	System.out.println("---");
        System.out.println("Identificador del proyecto: " + proyecto.getIdProject() + "\t");
        System.out.println("Fecha de inicio del proyecto: "  + proyecto.getStartDate()+ "\t");
        System.out.println("Fecha de finalización del proyecto: " + proyecto.getEndDate() + "\t");
    }
	return null;

	}

}

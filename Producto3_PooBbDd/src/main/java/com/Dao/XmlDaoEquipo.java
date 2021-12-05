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

	@Override
	public void guardarEquipos(Equipo equipo) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(equipo, new File(nombreFichero));
		System.out.println();
		System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
		System.out.println();
		marshaller.marshal(equipo, System.out);
	}

	@Override
	public Equipo listarEquipos() throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Equipo equipos = (Equipo) unmarshaller.unmarshal(new File(nombreFichero));

		System.out.println();
		System.out.println("Estos son los Equipos contenidos en el fichero " + nombreFichero);

		for (Equipo equipo : equipos.getEquipos()) {
			System.out.println("---");
			System.out.println("Identificador del equipo: " + equipo.getIdTeam() + "\t");
			System.out.println("Nombre del equipo: " + equipo.getTeamName() + "\t");
		}
		return null;
	}

}

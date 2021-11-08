package com.Dao;


	import javax.xml.bind.JAXBContext;
	import javax.xml.bind.JAXBException;
	import javax.xml.bind.Marshaller;
	import javax.xml.bind.Unmarshaller;

import com.ClasesConJAXB.Socio;

import java.io.File;
import java.util.ArrayList;

	public class XmlDaoSocio implements DaoSocio {

		private JAXBContext jaxbContext = null;
		private String nombreFichero = null;

		public XmlDaoSocio() throws JAXBException {
			this.jaxbContext = JAXBContext.newInstance(Socio.class);
			this.nombreFichero = "Socio.xml";
		}

		public void guardarSocios(Socio socios) throws JAXBException {
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(socios, new File(nombreFichero));
			System.out.println();
			System.out.println("Se ha escrito el fichero " + nombreFichero + " con el siguiente contenido:");
			System.out.println();
			marshaller.marshal(socios, System.out);
		}

		@Override
		public Socio listarSocios() throws JAXBException {
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Socio socios = (Socio) unmarshaller.unmarshal( new File(nombreFichero) );
		    
			System.out.println();
			System.out.println("Estos son los Equipos contenidos en el fichero " + nombreFichero);
			
		
		
		for(Socio socio : socios.getSocios())
	    {
	    	System.out.println("---");
	        System.out.println("Identificador del Socio: \t" + socio.getIdPartner());
	        System.out.println("Nombre del Socio: \t" + socio.getNamePartner());
	        System.out.println("Apellido del Socio: \t" + socio.getLastNamePartner());
	    }
		return null;
	}

		@Override
		public void guardarSocios(ArrayList<Socio> socios) throws JAXBException {
			// TODO Auto-generated method stub
			
		}


		

	}	
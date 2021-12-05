package com.Dao;

import javax.xml.bind.JAXBException;

public abstract class Dao {

	public static final int XML = 1;

	public abstract XmlDaoEquipo getDaoEquipo() throws JAXBException;

	public abstract XmlDaoSocio getDaoSocio() throws JAXBException;

	public abstract XmlDaoProyecto getDaoProyecto() throws JAXBException;

	public static Dao getDAO(int whichFactory) {

		switch (whichFactory) {
		case XML:
			return new XmlDAO();
		// case MYSQL:
		// return new MySqlDAOFactory();
		default:
			return null;
		}
	}

}

package com.Dao;

import javax.xml.bind.JAXBException;

import mysql.factory.MysqlDao;

public abstract class Dao {

	public static final int XML = 1;
	public static final int MYSQL = 2;

	public abstract DaoEquipo getDaoEquipo() throws JAXBException;

	public abstract DaoSocio getDaoSocio() throws JAXBException;

	public abstract DaoProyecto getDaoProyecto() throws JAXBException;

	public static Dao getDAO(int whichFactory) {

		switch (whichFactory) {
		case XML:
			return new XmlDAO();
		case MYSQL:
		return new MysqlDao();
		default:
			return null;
		}
	}

}

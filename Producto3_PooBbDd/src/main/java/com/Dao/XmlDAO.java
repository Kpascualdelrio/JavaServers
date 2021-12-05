package com.Dao;

import javax.xml.bind.JAXBException;

public class XmlDAO extends Dao {

	

	public XmlDaoEquipo getDaoEquipo() throws JAXBException {
		// TODO Auto-generated method stub
		return new XmlDaoEquipo();
	}
	
	public XmlDaoSocio getDaoSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return new XmlDaoSocio();
	}

	@Override
	public XmlDaoProyecto getDaoProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return new XmlDaoProyecto();
	}
	
	/*public XmlStandDAO getStandDAO() throws JAXBException {
		// XmlStandDAO implements IStandDAO
		return new XmlStandDAO();
	}
	public XmlStandModularDAO getStandModularDAO() throws JAXBException {
		//XmlStandModular implements IStandModularDAO
		return new XmlStandModularDAO();
		}
	public XmlStandOfertadoDAO getStandOfertadoDAO() throws JAXBException {
		//XmlStandOfertado implements IStandOfertadoDAO
		return new XmlStandOfertadoDAO();
	}

	
	public XmlStandPersonalizadoDAO getStandPersonalizadoDAO() throws JAXBException {
		// XmlStandPersonalizadoDAO implements IStandPersonalizadoDAO
		return new XmlStandPersonalizadoDAO();
	}
	
	
	
 
	
*/
}

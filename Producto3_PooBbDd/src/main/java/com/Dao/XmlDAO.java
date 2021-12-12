package com.Dao;

import javax.xml.bind.JAXBException;

public class XmlDAO extends Dao {

	@Override
	public DaoEquipo insertarEquipo() throws JAXBException {
		// TODO Auto-generated method stub
		return new XmlDaoEquipo();
	}

	@Override
	public DaoSocio insertaSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return new XmlDaoSocio();
	}

	@Override
	public DaoProyecto insertarProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoEquipo modificarEquipo() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoSocio modificarSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoProyecto modificarProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DaoEquipo eliminarEquipo() throws JAXBException{
		return null;
	}	
	
	@Override
	public DaoSocio eliminarSocio() throws JAXBException{
			return null;		
	}
	
	@Override
	public DaoProyecto eliminarProyecto() throws JAXBException{
		return null;
	}
	
	@Override
	public DaoEquipo obtenerTodos() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoSocio obtenerTodosSocio() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaoProyecto obtenerTodosProyecto() throws JAXBException {
		// TODO Auto-generated method stub
		return null;
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

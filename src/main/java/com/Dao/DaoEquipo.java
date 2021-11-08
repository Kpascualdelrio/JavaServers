package com.Dao;




import javax.xml.bind.JAXBException;

import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Equipos;


public interface DaoEquipo{
	
	public void guardarEquipos(Equipos equipos) throws JAXBException;
	public Equipo listarEquipos() throws JAXBException;
	

}

package com.Ongsonrisasporelmundo;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.ClasesConJAXB.Equipo;
import com.ClasesConJAXB.Equipos;
import com.ClasesConJAXB.ONG;
import com.Dao.Dao;
import com.Dao.XmlDaoEquipo;

import javax.xml.bind.JAXBException;

//@SpringBootApplication
public class Producto2SpringOngsonrisasporelmundoApplication {
	
	private static ONG ong;
	private static Equipo equipo1;
	private static Equipo equipo2;	
	private static Equipos equipos;
	
	
	private static ONG inicializaOng() {
		ong = new ONG("01","Sonrisas01");
		
		return ong;
	}
	private static Equipos inicializaEquipo() {
		equipo1 = new Equipo("Team01",ong,"TeamUSA","teamUSA");
		equipo2 = new Equipo("Team02",ong,"TeamEU","teamEU");
		
		Equipos equipos = new Equipos();
		equipos.add(equipo1);
		equipos.add(equipo2);
		
		return equipos;
		
	}

	public static void main(String[] args) throws JAXBException {
	//SpringApplication.run(Producto2SpringOngsonrisasporelmundoApplication.class, args);
		ong = inicializaOng();
		equipos = inicializaEquipo();
		
		Dao XmlDAO = Dao.getDAO(Dao.XML);
		XmlDaoEquipo equiposTest = XmlDAO.getDaoEquipo();
		equiposTest.guardarEquipos(equipos);
		equiposTest.listarEquipos();


}
}

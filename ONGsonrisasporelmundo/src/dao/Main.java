package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import clases.Equipo;
import clases.ONG;
import clases.Proyecto;
import clases.Socio;
import mysql.Mysqlproyecto;
import mysql.Mysqlsocio;

public class Main {

	public static void main(String[] args) throws SQLException, Daoexceptions {
		Connection conn=null;
		try {
			 conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/nombrebbdd","usuario", "contraseña");
			 //creo un objeto operaciondao y le añado una nueva conexión													
			 Sociodao sociodao= new Mysqlsocio(conn);
			 Proyectodao proyectodao= new Mysqlproyecto(conn);
			 
			 Socio sociojuan = new Socio("30PC","Juan Antonio", "de los palotes chinos");
			 Socio sociopedro= new Socio("25ZR","Pedro Sanchez", "Zapatero Rajoy");
			 Socio socioana = new Socio("20AR","Ana", "Rosamela");
			 
			 ONG ong= new ONG("SRSS","Sonrisas por el mundo");
			 Equipo medicos= new Equipo("MDCS",ong,"EL remedio que buscabas","Amoxicilina 500");
			 Proyecto proyecto =new Proyecto("BRF20",sociojuan,medicos,"2021-11-12","2024-01-10","funder","1,000,000","2021-2024","Construcción de escuelas","fe y alegria");
		 
			 // añado esa operación a la base de datos
			 sociodao.insertar(sociojuan);
			 sociodao.insertar(sociopedro);
			 sociodao.insertar(socioana);
			
			 proyectodao.insertar(proyecto);
			 // crearía una lista porque ese método devuelve un array
			 /*List<Socio> socios=dao.obtenerTodos();
			 for(Socio socios) {
				 System.out.println();
			 }*/
		}finally{
			
			if(conn!=null) {
				conn.close();
			}
		}

	}
}


